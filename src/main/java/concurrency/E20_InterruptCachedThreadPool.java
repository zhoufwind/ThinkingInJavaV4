package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LiftOff2 implements Runnable {
    protected int countDown = 5000;
    private static int taskCount;
    private final int id = taskCount++;

    public LiftOff2() {
    }

    public LiftOff2(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    public void run() {
        while (countDown-- > 0) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted: #" + id);
                return;
            }
            System.out.println(status());
            Thread.yield();
        }
    }
}

/**
 * 修改 CachedThreadPool.java，使所有的任务在完成前接收到 interrupt()
 */
public class E20_InterruptCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff2());
        }
        Thread.yield();
        exec.shutdownNow();
    }
}

/* Output
#0(4999),
#2(4999),
#3(4999),
#1(4999),
#4(4999),
#0(4998),
#1(4998),
#0(4997),
#3(4998),
#4(4998),
#2(4998),
#4(4997),
#3(4997),
#0(4996),
#1(4997),
#0(4995),
#1(4996),
#3(4996),
#4(4996),
#2(4997),
Interrupted: #4
Interrupted: #3
Interrupted: #1
Interrupted: #0
Interrupted: #2
 */