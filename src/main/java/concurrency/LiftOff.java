package concurrency;

/**
 * 演示runnable接口
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;   // Default
    private static int taskCount = 1;
    private final int id = taskCount++;

    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "), ";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
