package pers.xiaoming.notebook.concurrent.synchronized_and_lock.locks;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TryLockDemo {
    private Lock lock = new ReentrantLock();

    void get() {
        boolean getLock = lock.tryLock();
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
