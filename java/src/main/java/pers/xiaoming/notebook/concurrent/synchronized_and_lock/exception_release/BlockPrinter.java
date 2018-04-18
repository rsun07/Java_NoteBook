package pers.xiaoming.notebook.concurrent.synchronized_and_lock.exception_release;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockPrinter {
    synchronized int syncDiv(int a, int b) {
        int res = a / b;

        System.out.println(a + " / " + b + " = " + res);

        ThreadSleep.sleep();
        return res;
    }

    private Lock lock = new ReentrantLock();

    // not a good implementation
    // once block or exception, cannot release lock
    int poorLockDiv(int a, int b) {
        lock.lock();

        int res = a / b;

        System.out.println(a + " / " + b + " = " + res);

        ThreadSleep.sleep();

        lock.unlock();
        return res;
    }

    // not a good implementation
    // once block or exception, cannot release lock
    int lockDiv(int a, int b) {
        lock.lock();

        try {
            int res = a / b;

            System.out.println(a + " / " + b + " = " + res);

            ThreadSleep.sleep();

            return res;
        } finally {
            lock.unlock();
        }
    }
}
