package pers.xiaoming.notebook.concurrent.synchronized_and_lock.locks;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.Semaphore;

class SemaphorePrinter {
    private Semaphore semaphore;

    // except for only 1 permits semaphore doesn't achieve atomic
    SemaphorePrinter(int permits) {
        semaphore = new Semaphore(permits);
    }

    void print() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadSleep.sleep();

        try {
            System.out.println(Thread.currentThread() + " is Executing print.");
        } finally {
            semaphore.release();
        }
    }
}
