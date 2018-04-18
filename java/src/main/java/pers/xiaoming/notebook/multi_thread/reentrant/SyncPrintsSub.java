package pers.xiaoming.notebook.multi_thread.reentrant;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

class SyncPrintsSub extends SyncPrints {
    synchronized void print3() {
        System.out.println("print3");
        print2();
        ThreadSleep.sleep();
    }
}
