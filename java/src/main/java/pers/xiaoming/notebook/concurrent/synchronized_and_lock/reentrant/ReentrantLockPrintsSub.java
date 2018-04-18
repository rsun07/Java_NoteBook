package pers.xiaoming.notebook.concurrent.synchronized_and_lock.reentrant;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

class ReentrantLockPrintsSub extends ReentrantLockPrints {
    synchronized void print3() {
        relock.lock();
        try {
            System.out.println("print3");
            print2();
            ThreadSleep.sleep();
        } finally {
            relock.unlock();
        }
    }
}
