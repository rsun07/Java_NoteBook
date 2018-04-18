package pers.xiaoming.notebook.concurrent.volatile_keyword;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

class FailVisibility extends Thread {
    private boolean isStoped;

    FailVisibility() {
        this.isStoped = false;
    }

    void setStoped(boolean stop) {
        isStoped = stop;
    }

    @Override
    public void run() {
        while(!isStoped) {
            System.out.println("Thread still running");
            ThreadSleep.sleep(10);
        }
    }
}
