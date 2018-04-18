package pers.xiaoming.notebook.concurrent.synchronized_and_lock.locks;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TryLockDemo {
    private Lock lock = new ReentrantLock();

    void get() {
        boolean getLock = lock.tryLock();
        run(getLock);
    }

    void getWait() {
        boolean getLock = false;
        try {
            getLock = lock.tryLock(1200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        run(getLock);
    }

    private void run(boolean getLock) {
        System.out.println(Thread.currentThread() + " get lock " + getLock);

        if (getLock) {
            try {
                System.out.println(Thread.currentThread() + " running get ");
                ThreadSleep.sleep();
            } finally {
                lock.unlock();
            }
        }
    }
}
