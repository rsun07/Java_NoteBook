package pers.xiaoming.notebook.concurrent.synchronized_and_lock.synchronized_keyword;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

class SyncNonThis {
    private int[] lock = new int[]{1,2,3};

    void print1() {
        System.out.println(Thread.currentThread() + " Trying to access print 1 sync block");
        synchronized (this) {
            System.out.println("print1");
            ThreadSleep.sleep();
        }
    }

    // normally use final object as lock
    // here is only for demo
    void print2() {
        System.out.println(Thread.currentThread() + " Trying to access print 2 sync block");
        synchronized (lock) {
            System.out.println("Lock is : " + lock);
            System.out.println("print2");
            ThreadSleep.sleep();
        }
    }

    void print3() {
        System.out.println(Thread.currentThread() + " Trying to access print 3 sync block");
        lock[2] = 3;
        synchronized (lock) {
            System.out.println("Lock is : " + lock);
            System.out.println("print3");
            ThreadSleep.sleep();
        }
    }
}
