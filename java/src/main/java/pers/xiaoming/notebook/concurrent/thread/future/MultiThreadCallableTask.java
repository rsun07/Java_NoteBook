package pers.xiaoming.notebook.concurrent.thread.future;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.Callable;

class MultiThreadCallableTask implements Callable<Integer> {

    private static int count = 0;

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is running " + count++);
        ThreadSleep.sleepSecs(2);
        return count;
    }
}
