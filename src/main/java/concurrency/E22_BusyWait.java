package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 创建BUSY WAIT的例子。一个任务休眠一段时间，之后将flag设置为true。
 * 第二个任务观察flag，并且是在循环中进行观察，当flag变为true时，将其
 * 改为false，并且在终端打印出来。
 * 注意该方式十分耗时，创建一个使用wait()的版本进行优化。
 */
public class E22_BusyWait {
    private static volatile boolean flag;
    private static int spins;

    public static void main(String[] args) throws Exception {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                    flag = true;
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    // The busy-wait loop
                    while (!flag && !Thread.currentThread().isInterrupted()) {
                        spins++;
                    }
                    System.out.println("Spun " + spins + " times");
                    spins = 0;
                    flag = false;
                    if (Thread.interrupted()) {
                        return;
                    }
                }
            }
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(r1);
        exec.execute(r2);
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}
