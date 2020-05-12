package concurrency;

/**
 * Thread类基本用法
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff(), "线程1");
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
