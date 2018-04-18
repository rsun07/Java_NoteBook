package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WaitNotify {

    // config for producer comsumer
    private static int count = 0;
    private static final int QUEUE_SIZE = 10;
    private static final String LOCK = "lock";


    // config for thread pool
    private final static int corePoolSize = 5;
    private final static int maximumPoolSize = 5;
    private final static int keepAliveTime = 10;
    private final static TimeUnit unit = TimeUnit.MILLISECONDS;
    private final static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);

    public WaitNotify() {
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                // sleep is very important here
                // otherwise, consumer will get stuck and never go through
//                sleep();
                synchronized (LOCK) {
                    while (count == QUEUE_SIZE) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    this.produce();
                }
            }
        }

        private void produce() {
            count++;
            System.out.println(Thread.currentThread().getName() + "  Producer produce; " + " current count = " + count);
            LOCK.notifyAll();
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
//                sleep();
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    this.consume();
                }
            }
        }

        private void consume() {
            count--;
            System.out.println(Thread.currentThread().getName() + "  Consumer consume; " + " current count = " + count);
            LOCK.notifyAll();
        }
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();

//        traditionalTreadSolution(waitNotify);

        threadPoolSolution(waitNotify);

    }

    private static void traditionalTreadSolution(WaitNotify waitNotify) {
        new Thread(waitNotify.new Producer()).start();
        new Thread(waitNotify.new Consumer()).start();
        new Thread(waitNotify.new Producer()).start();
    }

    private static void threadPoolSolution(WaitNotify waitNotify) {
        ThreadPoolExecutor threadPoolExecutorLocal = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                new ThreadPoolExecutor.DiscardPolicy()
        );

        threadPoolExecutorLocal.execute(waitNotify.new Consumer());
        threadPoolExecutorLocal.execute(waitNotify.new Producer());
        threadPoolExecutorLocal.execute(waitNotify.new Producer());
        threadPoolExecutorLocal.execute(waitNotify.new Producer());
        threadPoolExecutorLocal.execute(waitNotify.new Consumer());
    }
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
