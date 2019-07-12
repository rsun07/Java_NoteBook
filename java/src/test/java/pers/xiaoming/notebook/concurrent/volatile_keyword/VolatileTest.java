package pers.xiaoming.notebook.concurrent.volatile_keyword;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Ignore("demo tests")
public class VolatileTest {
    private static final int NUM_OF_THREAD = 100;
    private ExecutorService executor;
    private CountDownLatch countDownLatch;

    @Before
    public void setup() {
        executor = Executors.newFixedThreadPool(NUM_OF_THREAD);
        countDownLatch = new CountDownLatch(NUM_OF_THREAD);
    }


    @Test
    public void testNoVisibility() throws InterruptedException {
        for (int i = 0; i < NUM_OF_THREAD; i++) {
            NoVolatileConsumer consumer = new NoVolatileConsumer(countDownLatch);
            executor.submit(consumer::run);
        }
        NoVolatileConsumer.setKeepRunning(false);
        System.out.println("Already set keepRunning to false");
        countDownLatch.await();
    }

    @Test
    public void testAchieveVisibility() throws InterruptedException {
        for (int i = 0; i < NUM_OF_THREAD; i++) {
            VolatileConsumer consumer = new VolatileConsumer(countDownLatch);
            executor.submit(consumer::run);
        }
        VolatileConsumer.setKeepRunning(false);
        System.out.println("Already set keepRunning to false");
        countDownLatch.await();
    }
}
