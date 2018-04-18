package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.object_lock;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

class SyncBothMethod implements IObjectLock {
    public synchronized void methodA() {
        System.out.println("Executing Method A");
        ThreadSleep.sleep500();
    }

    public synchronized void methodB() {
        System.out.println("Executing Method B");
    }
}
