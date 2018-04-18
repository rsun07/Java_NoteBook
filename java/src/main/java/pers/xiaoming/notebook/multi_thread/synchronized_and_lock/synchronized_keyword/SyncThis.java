package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.synchronized_keyword;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

class SyncThis {
    void print1() {
        System.out.println(Thread.currentThread() + " Trying to access print 1 sync block");
        synchronized (this) {
            System.out.println("print1");
            ThreadSleep.sleep();
        }
    }

    void print2() {
        System.out.println(Thread.currentThread() + " Trying to access print 2 sync block");
        synchronized (this) {
            System.out.println("print2");
            ThreadSleep.sleep();
        }
    }

    synchronized void print3() {
        System.out.println(Thread.currentThread() + " Trying to access print 3 sync block");
        System.out.println("print3");
        ThreadSleep.sleep();
    }
}
