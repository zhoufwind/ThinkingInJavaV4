package concurrency;

import java.util.concurrent.TimeUnit;

class NonTask {
    static void longMethod() throws InterruptedException {
        System.out.println("method start here");
        TimeUnit.SECONDS.sleep(60); // Waits one minute
    }
}

class Task implements Runnable {
    public void run() {
        try {
            NonTask.longMethod();
        } catch (InterruptedException e) {
            System.out.println(e.toString() + " @this position");
        } finally {
            // Any cleanup code here...
            System.out.println("task completed here");
        }
    }
}

public class E18_Interruption {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Task());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}

/*
method start here
java.lang.InterruptedException: sleep interrupted @this position
task completed here
 */
