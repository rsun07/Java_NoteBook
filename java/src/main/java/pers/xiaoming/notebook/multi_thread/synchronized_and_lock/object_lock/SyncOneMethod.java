package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.object_lock;

class SyncOneMethod implements IObjectLock {
    public synchronized void methodA() {
        System.out.println("Executing Method A");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        System.out.println("Executing Method B");
    }
}
