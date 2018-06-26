package pers.xiaoming.notebook.concurrent.thread.future;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.Callable;

class MultiThreadCallableTask implements Callable<String> {

    private static int count = 0;

    @Override
    public String call() throws Exception {
        String msg = String.format("%s is running num %d", Thread.currentThread().getName(), count++);
        System.out.println(msg);
        ThreadSleep.sleepSecs(2);
        return msg;
    }
}
