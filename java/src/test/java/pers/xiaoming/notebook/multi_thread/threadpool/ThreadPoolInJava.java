package pers.xiaoming.notebook.multi_thread.threadpool;

import java.util.concurrent.*;


/*
    Using the producer-consumer mode to show thread pool in Java

 */

public class ThreadPoolInJava {

    // config for producer comsumer
    private static int currentQueueSize;
    private static final int QUEUE_SIZE = 10;
    private static final String LOCK = "lock";

    private static int productComsumed;
    private static final int TOTAL_PRODUCT = 20;


    public ThreadPoolInJava() {
        currentQueueSize = 0;
        productComsumed = 0;
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (productComsumed + currentQueueSize <= TOTAL_PRODUCT) {
                // sleep is very important here
                // otherwise, consumer will get stuck and never go through
                sleep(1);
                synchronized (LOCK) {
                    while (currentQueueSize == QUEUE_SIZE) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (productComsumed + currentQueueSize <= TOTAL_PRODUCT) {
                        this.produce();
                    }
                }
            }
        }

        private void produce() {
            currentQueueSize++;
            System.out.println(Thread.currentThread().getName() + "  Producer produce; " + " current currentQueueSize = " + currentQueueSize
                + "; Total Product produced: " + (productComsumed + currentQueueSize) );
            LOCK.notifyAll();
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (productComsumed <= TOTAL_PRODUCT) {
                sleep(1);
                synchronized (LOCK) {
                    while (currentQueueSize == 0) {
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
            currentQueueSize--;
            productComsumed++;
            System.out.println(Thread.currentThread().getName() + "  Consumer consume; " + " current currentQueueSize = " + currentQueueSize
                + " consuming the product number : " + productComsumed);
            LOCK.notifyAll();
        }
    }

    private void sleep(int offset) {
        try {
            TimeUnit.SECONDS.sleep(offset);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolInJava threadPoolInJava = new ThreadPoolInJava();

//        traditionalTreadSolution(threadPoolInJava);

//        executorSolution(threadPoolInJava);

//        threadPoolExecutorSolution(threadPoolInJava);

        threadPoolExecutorWithMonitorSolution(threadPoolInJava);

    }

    private static void traditionalTreadSolution(ThreadPoolInJava threadPoolInJava) {
        new Thread(threadPoolInJava.new Producer()).start();
        new Thread(threadPoolInJava.new Consumer()).start();
        new Thread(threadPoolInJava.new Producer()).start();
    }


    private static void executorSolution(ThreadPoolInJava threadPoolInJava) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int producerSize = 3;
        int consumerSize = 2;

        for (int i = 0; i < producerSize; i++) {
            executor.execute(threadPoolInJava.new Producer());
        }

        for (int i = 0; i < consumerSize; i++) {
            executor.execute(threadPoolInJava.new Consumer());
        }

        executor.shutdown();
    }


    private static void threadPoolExecutorSolution(ThreadPoolInJava threadPoolInJava) {
        int corePoolSize = 5;
        int maximumPoolSize = 5;
        int keepAliveTime = 10;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);

        ThreadPoolExecutor threadPoolExecutorLocal = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                new ThreadPoolExecutor.DiscardPolicy()
        );

        threadPoolExecutorLocal.execute(threadPoolInJava.new Consumer());
        threadPoolExecutorLocal.execute(threadPoolInJava.new Producer());
        threadPoolExecutorLocal.execute(threadPoolInJava.new Producer());
        threadPoolExecutorLocal.execute(threadPoolInJava.new Producer());
        threadPoolExecutorLocal.execute(threadPoolInJava.new Consumer());

        threadPoolExecutorLocal.shutdown();
    }

    private static void threadPoolExecutorWithMonitorSolution(ThreadPoolInJava threadPoolInJava) {
        int corePoolSize = 5;
        int maximumPoolSize = 5;
        int keepAliveTime = 10;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandlerImpl();

        ThreadPoolExecutor threadPoolExecutorLocal = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                rejectionHandler
        );


        MyMonitorThread threadMonitor = new MyMonitorThread(threadPoolExecutorLocal, 1);

        threadPoolExecutorLocal.execute(threadMonitor);

        threadPoolExecutorLocal.execute(threadPoolInJava.new Consumer());
        threadPoolExecutorLocal.execute(threadPoolInJava.new Producer());
        threadPoolExecutorLocal.execute(threadPoolInJava.new Producer());
        threadPoolExecutorLocal.execute(threadPoolInJava.new Producer());
        threadPoolExecutorLocal.execute(threadPoolInJava.new Consumer());

        threadPoolInJava.sleep(20);

        threadMonitor.shutdown();
        threadPoolExecutorLocal.shutdown();
    }


    static class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(r.toString() + "is reject");
        }
    }

    static class MyMonitorThread implements Runnable {

        private ThreadPoolExecutor executor;
        private int seconds;
        private boolean run = true;

        public MyMonitorThread (ThreadPoolExecutor executor, int delay) {
            System.out.println("Monitor thread started! ");
            this.executor = executor;
            this.seconds = delay;
        }

        public void shutdown() {
            this.run = false;
            System.out.println("Monitor thread shut down! ");
        }

        @Override
        public void run() {
            while (run) {
                System.out.println(
                        String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                            this.executor.getPoolSize(),
                            this.executor.getCorePoolSize(),
                            this.executor.getActiveCount(),
                            this.executor.getCompletedTaskCount(),
                            this.executor.getTaskCount(),
                            this.executor.isShutdown(),
                            this.executor.isTerminated()));
                try {
                    Thread.sleep(seconds*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/*
    If you don't sleep within the threads, here is what happending

    cpu switch thread only when pool is full of product or pool has no product.

pool-1-thread-3  Producer produce;  current currentQueueSize = 1
pool-1-thread-3  Producer produce;  current currentQueueSize = 2
pool-1-thread-3  Producer produce;  current currentQueueSize = 3
pool-1-thread-3  Producer produce;  current currentQueueSize = 4
pool-1-thread-3  Producer produce;  current currentQueueSize = 5
pool-1-thread-3  Producer produce;  current currentQueueSize = 6
pool-1-thread-3  Producer produce;  current currentQueueSize = 7
pool-1-thread-3  Producer produce;  current currentQueueSize = 8
pool-1-thread-3  Producer produce;  current currentQueueSize = 9
pool-1-thread-3  Producer produce;  current currentQueueSize = 10
pool-1-thread-1  Consumer consume;  current currentQueueSize = 9
pool-1-thread-1  Consumer consume;  current currentQueueSize = 8
pool-1-thread-1  Consumer consume;  current currentQueueSize = 7
pool-1-thread-1  Consumer consume;  current currentQueueSize = 6
pool-1-thread-1  Consumer consume;  current currentQueueSize = 5
pool-1-thread-1  Consumer consume;  current currentQueueSize = 4
pool-1-thread-1  Consumer consume;  current currentQueueSize = 3
pool-1-thread-1  Consumer consume;  current currentQueueSize = 2
pool-1-thread-1  Consumer consume;  current currentQueueSize = 1
pool-1-thread-1  Consumer consume;  current currentQueueSize = 0
pool-1-thread-2  Producer produce;  current currentQueueSize = 1
pool-1-thread-2  Producer produce;  current currentQueueSize = 2
pool-1-thread-2  Producer produce;  current currentQueueSize = 3
pool-1-thread-2  Producer produce;  current currentQueueSize = 4
pool-1-thread-2  Producer produce;  current currentQueueSize = 5
pool-1-thread-2  Producer produce;  current currentQueueSize = 6
pool-1-thread-2  Producer produce;  current currentQueueSize = 7
pool-1-thread-2  Producer produce;  current currentQueueSize = 8
pool-1-thread-2  Producer produce;  current currentQueueSize = 9
pool-1-thread-2  Producer produce;  current currentQueueSize = 10
pool-1-thread-5  Consumer consume;  current currentQueueSize = 9
pool-1-thread-5  Consumer consume;  current currentQueueSize = 8
pool-1-thread-5  Consumer consume;  current currentQueueSize = 7
pool-1-thread-5  Consumer consume;  current currentQueueSize = 6
pool-1-thread-5  Consumer consume;  current currentQueueSize = 5
pool-1-thread-5  Consumer consume;  current currentQueueSize = 4
pool-1-thread-5  Consumer consume;  current currentQueueSize = 3
pool-1-thread-5  Consumer consume;  current currentQueueSize = 2
pool-1-thread-5  Consumer consume;  current currentQueueSize = 1
pool-1-thread-5  Consumer consume;  current currentQueueSize = 0
pool-1-thread-3  Producer produce;  current currentQueueSize = 1
pool-1-thread-3  Producer produce;  current currentQueueSize = 2
pool-1-thread-3  Producer produce;  current currentQueueSize = 3
pool-1-thread-3  Producer produce;  current currentQueueSize = 4
pool-1-thread-3  Producer produce;  current currentQueueSize = 5
pool-1-thread-3  Producer produce;  current currentQueueSize = 6
pool-1-thread-3  Producer produce;  current currentQueueSize = 7
pool-1-thread-3  Producer produce;  current currentQueueSize = 8
pool-1-thread-3  Producer produce;  current currentQueueSize = 9
pool-1-thread-3  Producer produce;  current currentQueueSize = 10
 */
