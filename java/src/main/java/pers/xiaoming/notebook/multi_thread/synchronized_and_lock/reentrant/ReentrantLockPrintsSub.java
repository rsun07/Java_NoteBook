package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.reentrant;

class ReentrantLockPrintsSub extends ReentrantLockPrints {
    synchronized void print3() {
        relock.lock();
        try {
            System.out.println("print3");
            print2();
            sleep();
        } finally {
            relock.unlock();
        }
    }
}
