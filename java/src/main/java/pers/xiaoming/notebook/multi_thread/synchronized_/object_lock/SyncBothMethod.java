package pers.xiaoming.notebook.multi_thread.synchronized_.object_lock;

class SyncBothMethod implements IObjectLock {
    public synchronized void methodA() {
        System.out.println("Executing Method A");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        System.out.println("Executing Method B");
    }
}
