package pers.xiaoming.notebook.multi_thread.synchronized_.reentrant;

class SyncPrints {
    synchronized void print1() {
        System.out.println("print1");
        sleep();
    }

    synchronized void print2() {
        System.out.println("print2");
        sleep();
    }

    synchronized void print3() {
        System.out.println("print3");
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
