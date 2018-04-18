package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.exception_release;

class BlockPrinter {
    synchronized int div(int a, int b) {
        int res = a / b;

        System.out.println(a + " / " + b + " = " + res);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }
}
