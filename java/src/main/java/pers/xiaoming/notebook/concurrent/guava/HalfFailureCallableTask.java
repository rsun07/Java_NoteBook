package pers.xiaoming.notebook.concurrent.guava;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Random;
import java.util.concurrent.Callable;

class HalfFailureCallableTask implements Callable<Integer> {
    private static final Random RANDOM = new Random();

    @Override
    public Integer call() throws Exception {
        int val = RANDOM.nextInt(100);
        if (val < 50) {
            System.out.println("Start task and wait");
            ThreadSleep.sleepSecs(2);
            return 100;
        } else {
            throw new RuntimeException("Call Fail");
        }
    }
}
