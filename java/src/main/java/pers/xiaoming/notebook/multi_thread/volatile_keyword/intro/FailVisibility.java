package pers.xiaoming.notebook.multi_thread.volatile_keyword.intro;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

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
