package pers.xiaoming.notebook.concurrent.thread.threadpool;

import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

// more for understanding the mechanism rather than run it
@Ignore("Demo Test, don't run in mvn build")
public class MyThreadPoolExecutorTest {
    private static final int CORE_POOL_SIZE = 100;
    private static final int LOOP_NUM = 3;

    @Test
    public void test() {
        MyThreadPoolExecutor poolExecutor = new MyThreadPoolExecutor(CORE_POOL_SIZE);

        for (int i = 0; i < CORE_POOL_SIZE; i++) {
            poolExecutor.execute(this::runTest);
        }

        ThreadSleep.sleepSecs(10);
    }

    private void runTest() {
        for (int i = 0; i < LOOP_NUM; i++) {
            ThreadSleep.sleep500();
            System.out.println(Thread.currentThread().getName() + " is Executing " + i);
        }
    }
}
