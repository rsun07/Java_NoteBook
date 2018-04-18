package pers.xiaoming.notebook.multi_thread.reentrant;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

class SyncPrints {
    synchronized void print1() {
        System.out.println("print1");
        ThreadSleep.sleep();
    }

    synchronized void print2() {
        System.out.println("print2");
        print1();
        ThreadSleep.sleep();
    }
}
