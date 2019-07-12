package pers.xiaoming.notebook.concurrent.volatile_keyword;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

class VolatileThread extends Thread {
    private volatile boolean keepRunning;

    VolatileThread() {
        this.keepRunning = true;
    }

    void setKeepRunning(boolean running) {
        keepRunning = running;
    }

    @Override
    public void run() {
        while(keepRunning) {
            System.out.println("Thread still running");
            ThreadSleep.sleep(1);
        }
    }
}
