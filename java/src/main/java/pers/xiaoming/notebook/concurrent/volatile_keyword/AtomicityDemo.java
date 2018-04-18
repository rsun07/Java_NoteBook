package pers.xiaoming.notebook.concurrent.volatile_keyword;

public class AtomicityDemo extends Thread {
    volatile int res;

    int syncRes;

    void addRes() {
        res++;
    }

    synchronized void addResSynchronized() {
        syncRes++;
    }

    int getRes(boolean isSync) {
        return isSync ? syncRes : res;
    }

}
