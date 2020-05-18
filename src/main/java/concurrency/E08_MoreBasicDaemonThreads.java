package concurrency;

/**
 * 后台线程还未执行完毕，前台main结束后，后台线程强行结束
 */
public class E08_MoreBasicDaemonThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new LiftOff());
            t.setDaemon(true);
            t.start();
        }
        System.out.println("Waiting for LiftOff");
    }
}

/* Output
#1(9), #3(9), #2(9), #4(9), Waiting for LiftOff
#5(9), #1(8), #3(8), #2(8), #4(8), #5(8), #1(7), #2(7), #4(7), #3(7), #4(6), #2(6),
 */
