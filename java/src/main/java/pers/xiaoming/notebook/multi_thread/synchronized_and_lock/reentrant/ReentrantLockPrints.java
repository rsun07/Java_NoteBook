package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockPrints {
    final ReentrantLock relock = new ReentrantLock();

    void print1() {
        relock.lock();
        try {
            System.out.println("print1");
            sleep();
        } finally {
            relock.unlock();
        }
    }

    synchronized void print2() {
        relock.lock();
        try {
            System.out.println("print2");
            print1();
            sleep();
        } finally {
            relock.unlock();
        }
    }

    void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
