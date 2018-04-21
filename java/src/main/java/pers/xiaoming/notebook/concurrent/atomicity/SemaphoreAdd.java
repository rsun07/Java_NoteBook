package pers.xiaoming.notebook.concurrent.atomicity;

import java.util.concurrent.Semaphore;

class SemaphoreAdd implements ConcurrentAdd {
    private int res;
    private Semaphore semaphore;

    SemaphoreAdd(int permits) {
        this.res = 0;
        this.semaphore = new Semaphore(permits);
    }

    @Override
    public int add() {
        return add(1);
    }

    @Override
    public int add(int i) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            res += i;
            return res;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public int getRes() {
        return res;
    }
}
