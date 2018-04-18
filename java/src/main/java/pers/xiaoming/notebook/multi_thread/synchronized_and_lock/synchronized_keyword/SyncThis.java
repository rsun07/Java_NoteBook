package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.synchronized_keyword;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

class SyncThis {
    void print1() {
        synchronized (this) {
            System.out.println("print1");
            ThreadSleep.sleep();
        }
    }

    void print2() {
        synchronized (this) {
            System.out.println("print2");
            ThreadSleep.sleep();
        }
    }

    synchronized void print3() {
        System.out.println("print2");
        ThreadSleep.sleep();
    }
}
