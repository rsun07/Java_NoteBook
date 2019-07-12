package pers.xiaoming.notebook.concurrent.volatile_keyword;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.CountDownLatch;

class VolatileConsumer {
    private static volatile boolean keepRunning = true;
    private CountDownLatch countDownLatch;

    public VolatileConsumer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    static void setKeepRunning(boolean running) {
        keepRunning = running;
    }

    public void run() {
        while(keepRunning) {
            System.out.println(Thread.currentThread().getName() + " is running");
            ThreadSleep.sleep(5);
        }
        countDownLatch.countDown();
    }
}
