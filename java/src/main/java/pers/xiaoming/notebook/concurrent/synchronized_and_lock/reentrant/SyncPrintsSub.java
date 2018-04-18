package pers.xiaoming.notebook.concurrent.synchronized_and_lock.reentrant;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

class SyncPrintsSub extends SyncPrints {
    synchronized void print3() {
        System.out.println("print3");
        print2();
        ThreadSleep.sleep();
    }
}
