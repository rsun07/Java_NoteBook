package pers.xiaoming.notebook.multi_thread.volatile_keyword.intro;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

public class AtomicityTest {
    /*
        Every time it run, the result is different but less than 1000*1000
        Time cost is around 110ms
     */
    @Test
    public void failAtomicity() {
        FailAtomicity testClass = new FailAtomicity();

        Instant start = Instant.now();

        for (int i = 0; i < 1000; i++) {
            new Thread(
                () -> {
                    for (int j = 0; j < 1000; j++) {
                        testClass.addRes();
                    }
                }
            ).start();
        }

        Instant end = Instant.now();

        System.out.printf("Result is %d, \nTime cost is %s\n",
                testClass.getRes(), Duration.between(start, end).toMillis());
    }
}
