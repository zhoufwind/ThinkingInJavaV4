package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class E06_SleepingTask2_2 {
    private static final ExecutorService es = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Provide the quantity of tasks to run");
            return;
        }

        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            es.execute(() -> {
                Random rnd = new Random();
                int sleep_time = rnd.nextInt(10) + 1;
                try {
                    TimeUnit.SECONDS.sleep(sleep_time);
                } catch (InterruptedException e) {
                    System.err.println("Interrupted: " + e);
                }
                System.out.println(sleep_time);
            });
        }
        es.shutdown();

        System.out.println("I will show up first whatever!");
    }
}

/* Output:
I will show up first whatever!
2
3
5
7
8
 */
