package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.print;

class ExplicitSingleSynch {
    private Lock lock = new ReentrantLock();

    public void f() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                print("f()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public void g() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                print("g()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public void h() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                print("h()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
}

class ExplicitTripleSynch {
    private Lock lockF = new ReentrantLock();
    private Lock lockG = new ReentrantLock();
    private Lock lockH = new ReentrantLock();

    public void f() {
        lockF.lock();
        try {
            for (int i = 0; i < 5; i++) {
                print("f()");
                Thread.yield();
            }
        } finally {
            lockF.unlock();
        }
    }

    public void g() {
        lockG.lock();
        try {
            for (int i = 0; i < 5; i++) {
                print("g()");
                Thread.yield();
            }
        } finally {
            lockG.unlock();
        }
    }

    public void h() {
        lockH.lock();
        try {
            for (int i = 0; i < 5; i++) {
                print("h()");
                Thread.yield();
            }
        } finally {
            lockH.unlock();
        }
    }
}

public class E16_ExplicitSyncObject {
    public static void main(String[] args) throws Exception {
        final ExplicitSingleSynch singleSynch = new ExplicitSingleSynch();
        final ExplicitSingleSynch tripleSynch = new ExplicitSingleSynch();

        print("Test ExplicitSingleSynch...");
        Thread t1 = new Thread() {
            public void run() {
                singleSynch.f();
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            public void run() {
                singleSynch.g();
            }
        };
        t2.start();
        singleSynch.h();
        t1.join();
        t2.join();

        print("Test ExplicitTripleSynch...");
        new Thread() {
            public void run() {
                tripleSynch.f();
            }
        }.start();
        new Thread() {
            public void run() {
                tripleSynch.g();
            }
        }.start();
        tripleSynch.h();
    }
}

/* Output
Test ExplicitSingleSynch...
f()
f()
f()
f()
f()
h()
h()
h()
h()
h()
g()
g()
g()
g()
g()
Test ExplicitTripleSynch...
f()
f()
f()
f()
f()
h()
h()
h()
h()
h()
g()
g()
g()
g()
g()
 */
