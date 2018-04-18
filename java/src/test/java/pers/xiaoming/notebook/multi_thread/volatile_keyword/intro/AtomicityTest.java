package pers.xiaoming.notebook.multi_thread.volatile_keyword.intro;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

public class AtomicityTest {
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

        Instant start = Instant.now();

        for (int i = 0; i < 1000; i++) {
            new Thread(
                () -> {
                    for (int j = 0; j < 1000; j++) {
                        if (isSynchroized) {
                            testClass.addResSynchronized();
                        } else {
                            testClass.addRes();
                        }
                    }
                }
            ).start();
        }

        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        Instant end = Instant.now();

        System.out.printf("Result is %d, \nTime cost is %s\n",
                testClass.getRes(isSynchroized), Duration.between(start, end).toMillis());
    }
}
