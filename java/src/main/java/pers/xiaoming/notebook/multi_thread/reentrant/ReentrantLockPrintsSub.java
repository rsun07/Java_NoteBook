package pers.xiaoming.notebook.multi_thread.reentrant;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

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
