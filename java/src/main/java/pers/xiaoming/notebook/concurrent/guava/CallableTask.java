package pers.xiaoming.notebook.concurrent.guava;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Random;
import java.util.concurrent.Callable;

class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Start task and wait");
        ThreadSleep.sleepSecs(2);
        return 100;
    }
}
