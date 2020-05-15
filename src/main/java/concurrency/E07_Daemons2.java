package concurrency;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.printnb;

class Daemon2 implements Runnable {
    private Thread[] t = new Thread[10];

    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            printnb("DaemonSpawn " + i + " started. ");
        }
        try {
            // To better see the effect of altering main application thread's sleep time
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < t.length; i++) {
            printnb("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

public class E07_Daemons2 {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Sleep time needs to be provided in msecs");
            return;
        }
        int sleep_time = Integer.parseInt(args[0]);
        Thread d = new Thread(new Daemon2());
        d.setDaemon(true);
        d.start();
        printnb("d.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.MILLISECONDS.sleep(sleep_time);
    }
}

/*
d.isDaemon() = true,
DaemonSpawn 0 started. DaemonSpawn 1 started.
DaemonSpawn 2 started. DaemonSpawn 3 started.
DaemonSpawn 4 started. DaemonSpawn 5 started.
DaemonSpawn 6 started. DaemonSpawn 7 started.
DaemonSpawn 8 started. DaemonSpawn 9 started.
t[0].isDaemon() = true, t[1].isDaemon() = true,
t[2].isDaemon() = true, t[3].isDaemon() = true,
t[4].isDaemon() = true, t[5].isDaemon() = true,
t[6].isDaemon() = true, t[7].isDaemon() = true,
t[8].isDaemon() = true, t[9].isDaemon() = true,
 */
