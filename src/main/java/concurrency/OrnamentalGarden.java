package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    // Doesn't need synchronization to read:
    private final int id;
    private static volatile boolean canceled = false;

    // Atomic operation on a volatile field:
    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        // Keep this task in a list. Also prevents garbage collection of dead tasks:
        entrances.add(this);
    }

    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                print("sleep interrupted");
            }
        }
        print("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}

/**
 * 公园游客入园数量统计
 */
public class OrnamentalGarden {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        // Run for a while, then stop and collect the data:
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdownNow();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            print("Some tasks were not terminated!");
        }
        print("Total: " + Entrance.getTotalCount());
        print("Sum of Entrances: " + Entrance.sumEntrances());
    }
}

/* Output
Entrance 0: 1 Total: 1
Entrance 1: 1 Total: 2
Entrance 3: 1 Total: 4
Entrance 4: 1 Total: 5
Entrance 2: 1 Total: 3
Entrance 0: 2 Total: 6
Entrance 1: 2 Total: 10
Entrance 4: 2 Total: 9
Entrance 2: 2 Total: 7
Entrance 3: 2 Total: 8
...
Entrance 0: 29 Total: 141
Entrance 3: 29 Total: 144
Entrance 4: 29 Total: 143
Entrance 1: 29 Total: 142
Entrance 2: 29 Total: 145
Entrance 3: 30 Total: 146
Entrance 2: 30 Total: 149
Entrance 1: 30 Total: 148
Entrance 4: 30 Total: 147
Entrance 0: 30 Total: 150
sleep interrupted
sleep interrupted
Stopping Entrance 0: 30
sleep interrupted
Stopping Entrance 3: 30
sleep interrupted
Stopping Entrance 1: 30
sleep interrupted
Stopping Entrance 2: 30
Stopping Entrance 4: 30
Total: 150
Sum of Entrances: 150
 */