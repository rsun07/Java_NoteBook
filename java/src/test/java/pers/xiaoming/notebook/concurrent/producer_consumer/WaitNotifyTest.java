package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WaitNotifyTest {
    // config for thread pool
    private final static int corePoolSize = 5;
    private final static int maximumPoolSize = 5;
    private final static int keepAliveTime = 10;
    private final static TimeUnit unit = TimeUnit.MILLISECONDS;
    private final static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);

    public static void main(String[] args) {
        WaitNotifyImpl waitNotifyImpl = new WaitNotifyImpl();

//        traditionalTreadSolution(waitNotifyImpl);

        threadPoolSolution(waitNotifyImpl);

    }

    private static void traditionalTreadSolution(WaitNotifyImpl waitNotifyImpl) {
        new Thread(waitNotifyImpl.new Producer()).start();
        new Thread(waitNotifyImpl.new Consumer()).start();
        new Thread(waitNotifyImpl.new Producer()).start();
    }

    private static void threadPoolSolution(WaitNotifyImpl waitNotifyImpl) {
        ThreadPoolExecutor threadPoolExecutorLocal = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                new ThreadPoolExecutor.DiscardPolicy()
        );

        threadPoolExecutorLocal.execute(waitNotifyImpl.new Consumer());
        threadPoolExecutorLocal.execute(waitNotifyImpl.new Producer());
        threadPoolExecutorLocal.execute(waitNotifyImpl.new Producer());
        threadPoolExecutorLocal.execute(waitNotifyImpl.new Producer());
        threadPoolExecutorLocal.execute(waitNotifyImpl.new Consumer());
    }

    /*
    If you don't sleep within the threads, here is what happending

    cpu switch thread only when pool is full of product or pool has no product.

pool-1-thread-3  Producer produce;  current count = 1
pool-1-thread-3  Producer produce;  current count = 2
pool-1-thread-3  Producer produce;  current count = 3
pool-1-thread-3  Producer produce;  current count = 4
pool-1-thread-3  Producer produce;  current count = 5
pool-1-thread-3  Producer produce;  current count = 6
pool-1-thread-3  Producer produce;  current count = 7
pool-1-thread-3  Producer produce;  current count = 8
pool-1-thread-3  Producer produce;  current count = 9
pool-1-thread-3  Producer produce;  current count = 10
pool-1-thread-1  Consumer consume;  current count = 9
pool-1-thread-1  Consumer consume;  current count = 8
pool-1-thread-1  Consumer consume;  current count = 7
pool-1-thread-1  Consumer consume;  current count = 6
pool-1-thread-1  Consumer consume;  current count = 5
pool-1-thread-1  Consumer consume;  current count = 4
pool-1-thread-1  Consumer consume;  current count = 3
pool-1-thread-1  Consumer consume;  current count = 2
pool-1-thread-1  Consumer consume;  current count = 1
pool-1-thread-1  Consumer consume;  current count = 0
pool-1-thread-2  Producer produce;  current count = 1
pool-1-thread-2  Producer produce;  current count = 2
pool-1-thread-2  Producer produce;  current count = 3
pool-1-thread-2  Producer produce;  current count = 4
pool-1-thread-2  Producer produce;  current count = 5
pool-1-thread-2  Producer produce;  current count = 6
pool-1-thread-2  Producer produce;  current count = 7
pool-1-thread-2  Producer produce;  current count = 8
pool-1-thread-2  Producer produce;  current count = 9
pool-1-thread-2  Producer produce;  current count = 10
pool-1-thread-5  Consumer consume;  current count = 9
pool-1-thread-5  Consumer consume;  current count = 8
pool-1-thread-5  Consumer consume;  current count = 7
pool-1-thread-5  Consumer consume;  current count = 6
pool-1-thread-5  Consumer consume;  current count = 5
pool-1-thread-5  Consumer consume;  current count = 4
pool-1-thread-5  Consumer consume;  current count = 3
pool-1-thread-5  Consumer consume;  current count = 2
pool-1-thread-5  Consumer consume;  current count = 1
pool-1-thread-5  Consumer consume;  current count = 0
pool-1-thread-3  Producer produce;  current count = 1
pool-1-thread-3  Producer produce;  current count = 2
pool-1-thread-3  Producer produce;  current count = 3
pool-1-thread-3  Producer produce;  current count = 4
pool-1-thread-3  Producer produce;  current count = 5
pool-1-thread-3  Producer produce;  current count = 6
pool-1-thread-3  Producer produce;  current count = 7
pool-1-thread-3  Producer produce;  current count = 8
pool-1-thread-3  Producer produce;  current count = 9
pool-1-thread-3  Producer produce;  current count = 10
 */
}
