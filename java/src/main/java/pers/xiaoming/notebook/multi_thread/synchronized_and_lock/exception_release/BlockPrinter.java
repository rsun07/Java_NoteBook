package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.exception_release;

import pers.xiaoming.notebook.multi_thread.util.ThreadSleep;

class BlockPrinter {
    synchronized int div(int a, int b) {
        int res = a / b;

        System.out.println(a + " / " + b + " = " + res);

        ThreadSleep.sleep();
        return res;
    }
}
