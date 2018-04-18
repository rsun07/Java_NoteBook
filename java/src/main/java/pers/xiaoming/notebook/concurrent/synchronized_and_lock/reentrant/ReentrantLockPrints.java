package pers.xiaoming.notebook.concurrent.synchronized_and_lock.reentrant;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockPrints {
    final ReentrantLock relock = new ReentrantLock();

    void print1() {
        relock.lock();
        try {
            System.out.println("print1");
            ThreadSleep.sleep();
        } finally {
            relock.unlock();
        }
    }

    synchronized void print2() {
        relock.lock();
        try {
            System.out.println("print2");
            print1();
            ThreadSleep.sleep();
        } finally {
            relock.unlock();
        }
    }
}
