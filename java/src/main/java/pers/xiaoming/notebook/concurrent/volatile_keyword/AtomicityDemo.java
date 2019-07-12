package pers.xiaoming.notebook.concurrent.volatile_keyword;

public class AtomicityDemo extends Thread {
    volatile int i;

    int syncI;

    void addI() {
        i++;
    }

    synchronized void addISynchronized() {
        syncI++;
    }

    int getRes(boolean isSync) {
        return isSync ? syncI : i;
    }

}
