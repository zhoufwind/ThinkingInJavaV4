package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E03_Runnable2 {
    public static void main(String[] args) {
        System.out.println("newCachedThreadPool()");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Printer());
        }
        Thread.yield();
        exec.shutdown();

        System.out.println("newFixedThreadPool(5)");
        exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new Printer());
        }
        Thread.yield();
        exec.shutdown();

        System.out.println("newSingleThreadExecutor()");
        exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Printer());
        }
        Thread.yield();
        exec.shutdown();
    }
}
