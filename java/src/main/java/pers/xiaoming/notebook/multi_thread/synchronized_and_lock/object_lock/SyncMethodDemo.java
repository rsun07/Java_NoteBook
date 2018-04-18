package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.object_lock;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

public class SyncMethodDemo {
    public void nonSyncMethod() {
        System.out.println("Executing Non Synchronized Method");
    }

    public synchronized void syncMethod() {
        System.out.println("Executing Synchronized Method");
        ThreadSleep.sleep500();
    }

    public synchronized void syncMethodCopy() {
        System.out.println("Executing Synchronized Method Copy");
        ThreadSleep.sleep500();
    }

    public static synchronized void staticSyncMethod() {
        System.out.println("Executing Static Synchronized Method");
        ThreadSleep.sleep500();
    }

    public static synchronized void staticSyncMethodCopy() {
        System.out.println("Executing Static Synchronized Method Copy");
        ThreadSleep.sleep500();
    }
}
