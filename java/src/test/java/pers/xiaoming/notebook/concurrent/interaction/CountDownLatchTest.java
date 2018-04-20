package pers.xiaoming.notebook.concurrent.interaction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchTest {
    private static final int TOTAL_THREAD_NUM = 100;
    private static final int RUN_FREQUENCY = 100;
    private static final int EXP_RESULT = TOTAL_THREAD_NUM * RUN_FREQUENCY;

    private static final ReentrantLock lock = new ReentrantLock();
    private int res;

    @Before
    public void setup() {
        res = 0;
    }

    @Test
    public void testNoCount() {
        for (int i = 0; i < TOTAL_THREAD_NUM; i++) {
            new Thread(
                () -> {
                    for (int j = 0; j < RUN_FREQUENCY; j++) {
                        lock.lock();
                        try {
                            res++;
                        } finally {
                            lock.unlock();
                        }
                    }
                }
            ).start();
        }

        Assert.assertTrue(EXP_RESULT > res);
    }


    @Test
    public void testCount() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(TOTAL_THREAD_NUM);

        for (int i = 0; i < TOTAL_THREAD_NUM; i++) {
            new Thread(
                () -> {
                    for (int j = 0; j < RUN_FREQUENCY; j++) {
                        lock.lock();
                        try {
                            res++;
                        } finally {
                            lock.unlock();
                        }
                    }
                    countDownLatch.countDown();
                }
            ).start();
        }

        countDownLatch.await();
        Assert.assertEquals(EXP_RESULT, res);
    }
}
