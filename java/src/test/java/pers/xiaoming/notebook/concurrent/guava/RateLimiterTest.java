package pers.xiaoming.notebook.concurrent.guava;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

@Ignore("demo test")
public class RateLimiterTest {
    private static final int TOTAL_THREAD_NUM = 3;
    private static final int RATE_LIMIT = 10;

    private Map<Integer, Integer> counter = new ConcurrentHashMap<>();
    private RateLimiter rateLimiter = RateLimiter.create(RATE_LIMIT);
    private CountDownLatch countDownLatch = new CountDownLatch(TOTAL_THREAD_NUM);

    @Test
    public void testRateLimiter() throws InterruptedException {
        for (int i = 0; i < TOTAL_THREAD_NUM; i++) {
            new Thread(this::count).start();
        }

        countDownLatch.await();
        System.out.println(counter.toString());

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Assert.assertSame(RATE_LIMIT, entry.getValue());
        }
    }

    private void count() {
        for (int i = 0; i < RATE_LIMIT*2; i++) {
            rateLimiter.acquire(1);
            int startTime = ZonedDateTime.now().getSecond();
            if (counter.containsKey(startTime)) {
                counter.put(startTime, counter.get(startTime) + 1);
            } else {
                counter.put(startTime, 1);
            }
        }
        countDownLatch.countDown();
    }
}
