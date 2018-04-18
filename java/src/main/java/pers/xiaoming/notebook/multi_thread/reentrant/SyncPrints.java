package pers.xiaoming.notebook.multi_thread.reentrant;

class SyncPrints {
    synchronized void print1() {
        System.out.println("print1");
        sleep();
    }

    synchronized void print2() {
        System.out.println("print2");
        print1();
        sleep();
    }

    void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
