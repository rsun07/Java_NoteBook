package pers.xiaoming.notebook.concurrent.atomicity;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("don't run in mvn build")
public class AtomicityTest {
    private static final int CONCURRENT_THREAD_NUM = 1000;
    private static final int RUN_FREQUENCY = 1000;
    private static final int EXPECT_RES = CONCURRENT_THREAD_NUM * RUN_FREQUENCY;

    @Test
    public void testNonAtomicAdd() {
        ConcurrentAdd addClass = new NonAtomicAdd();
        int res = test(addClass);
        Assert.assertTrue(res < EXPECT_RES);
    }

    @Test
    public void testVolatileAtomicAdd() {
        ConcurrentAdd addClass = new VolatileAdd();
        int res = test(addClass);
        Assert.assertTrue(res < EXPECT_RES);
    }

    @Test
    public void testAtomicAtomicAdd() {
        ConcurrentAdd addClass = new AtomicAdd();
        int res = test(addClass);
        Assert.assertEquals(EXPECT_RES, res);
    }

    @Test
    public void testSyncAtomicAdd() {
        ConcurrentAdd addClass = new SyncAdd();
        int res = test(addClass);
        Assert.assertEquals(EXPECT_RES, res);
    }

    @Test
    public void testThreadLocalAtomicAdd() {
        ConcurrentAdd addClass = new ThreadLocalAdd();
        int res = test(addClass);
        Assert.assertEquals(0, res);
    }

    private int test(ConcurrentAdd addClass) {
        for (int i = 0; i < CONCURRENT_THREAD_NUM; i++) {
            new Thread(
                    () -> {
                        for (int j = 0; j < RUN_FREQUENCY; j++) {
                            addClass.add();
                        }

                        // for thread local only
                        if (addClass instanceof ThreadLocalAdd) {
                            Assert.assertEquals(RUN_FREQUENCY, addClass.getRes());
                        }
                    }
            ).start();
        }

        // wait all thread finish
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        int res = addClass.getRes();

        String[] paths = addClass.getClass().getName().split("\\.");
        String className = paths[paths.length - 1];

        System.out.println("Result for " + className + " is : " + res);
        return res;
    }
}
