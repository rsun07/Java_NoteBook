package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.reentrant;

class SyncPrintsSub extends SyncPrints {
    synchronized void print3() {
        System.out.println("print3");
        print2();
        sleep();
    }
}
