package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class Coop1 implements Runnable {
    public Coop1() {
        print("Constructed Coop1");
    }

    public void run() {
        print("Coop1 going to wait");
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        print("Coop1 exited wait");
    }
}

class Coop2 implements Runnable {
    final Runnable otherTask;

    public Coop2(Runnable otherTask) {
        this.otherTask = otherTask;
        print("Constructed Coop2");
    }

    public void run() {
        print("Coop2 pausing 5 second");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Coop2 calling notifyAll");
        synchronized (otherTask) {
            otherTask.notifyAll();
        }
    }
}

/**
 * 创建2个runnable，其中一个的run()运行并且调用wait()。
 * 另一个类需要捕获到第一个runnable对象，它的run()需要在
 * 几秒钟后为第一个对象调用notifyAll()，由此第一个任务能
 * 够打印信息。通过Executor进行测试。
 */
public class E21_ThreadCooperation {
    public static void main(String[] args) throws Exception {
        Runnable coop1 = new Coop1(),
                coop2 = new Coop2(coop1);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(coop1);
        exec.execute(coop2);
        Thread.yield();
        exec.shutdown();
    }
}

/* Output
Constructed Coop1
Constructed Coop2
Coop1 going to wait
Coop2 pausing 5 second
Coop2 calling notifyAll
Coop1 exited wait
 */