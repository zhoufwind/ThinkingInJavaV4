package concurrency;

/**
 * 加入更多线程
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Thread(new LiftOff(), "线程" + i).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
