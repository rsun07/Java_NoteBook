package pers.xiaoming.notebook.concurrent.volatile_keyword;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;

public class AtomicityTest {
    private static final int CONCURRENT_THREAD_NUM = 100;
    private static final int RUN_FREQUENCY = 100;
    private static final int EXPECT_RES = CONCURRENT_THREAD_NUM * RUN_FREQUENCY;

    /*
        Every time it run, the result is different but less than 1000*1000
        Time cost is around 110ms
     */
    @Test
    public void testFailAtomicity() {
        test(false);
    }

    /*
        Result is guarantee to be 1000000,
        Time cost is 128
     */
    @Test
    public void testAchieveAtomicity() {
        test(true);
    }

    private void test(boolean isSynchroized) {
        AtomicityDemo testClass = new AtomicityDemo();

        CountDownLatch countDownLatch = new CountDownLatch(CONCURRENT_THREAD_NUM);

        Instant start = Instant.now();

        for (int i = 0; i < CONCURRENT_THREAD_NUM; i++) {
            new Thread(
                () -> {
                    for (int j = 0; j < RUN_FREQUENCY; j++) {
                        if (isSynchroized) {
                            testClass.addISynchronized();
                        } else {
                            testClass.addI();
                        }
                    }
                    countDownLatch.countDown();
                }
            ).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();

        int res = testClass.getRes(isSynchroized);
        if (isSynchroized) {
            Assert.assertEquals(EXPECT_RES, res);
        } else {
            Assert.assertTrue(EXPECT_RES > res);
        }

        System.out.printf("Result is %d, \nTime cost is %s\n\n",
                testClass.getRes(isSynchroized), Duration.between(start, end).toMillis());
    }
}
