package pers.xiaoming.notebook.multi_thread.volatile_keyword.intro;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

class AchieveVisibility extends Thread {
    private volatile boolean isStoped;

    AchieveVisibility() {
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
