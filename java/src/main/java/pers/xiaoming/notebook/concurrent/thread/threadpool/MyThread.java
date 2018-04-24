package pers.xiaoming.notebook.concurrent.thread.threadpool;

class MyThread extends Thread {
    private Runnable myRunnable;

    MyThread() {}

    MyThread(Runnable myRunnable) {
        super(myRunnable);
    }

    public void setMyRunnable(Runnable myRunnable) {
        this.myRunnable = myRunnable;
    }
}
