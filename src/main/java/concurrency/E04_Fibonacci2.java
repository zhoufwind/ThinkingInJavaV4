package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * execute
 */
public class E04_Fibonacci2 {
    public static void main(String[] args) {
        System.out.println("newCachedThreadPool()");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++) {
            exec.execute(new Fibonacci(i));
        }
        Thread.yield();
        exec.shutdown();

        System.out.println("newFixedThreadPool(5)");
        exec = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            exec.execute(new Fibonacci(i));
        }
        Thread.yield();
        exec.shutdown();

        System.out.println("newSingleThreadExecutor()");
        exec = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++) {
            exec.execute(new Fibonacci(i));
        }
        Thread.yield();
        exec.shutdown();
    }
}
