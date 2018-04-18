package pers.xiaoming.notebook.multi_thread.reentrant;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

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
