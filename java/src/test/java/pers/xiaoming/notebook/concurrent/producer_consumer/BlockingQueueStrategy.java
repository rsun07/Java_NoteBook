package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.concurrent.*;

public class BlockingQueueStrategy {

    private static final int QUEUE_SIZE = 5;
    // no longer need the synchronized and lock because the blocking queue helps that
    private static final String LOCK = "lock";

    private BlockingQueue queue;

    private static final int TOTAL_PRODUCT = 20;
    private static int count;

    public BlockingQueueStrategy() {
        queue = new LinkedBlockingDeque<Integer>(QUEUE_SIZE);
        count = 0;
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (count <= TOTAL_PRODUCT) {
                sleep(1);
                produce1();
            }
        }


        // multi thread access count at the same time
        private void produce0() {
            try {
                ++count;
                queue.put(count);
                System.out.println("Producer " + Thread.currentThread().getName() + " is producing  number " + count
                        + " ; Total product produced is " + count + " for now ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /* synchronized in the function doesn't work
            This is because, every thread start a new runnable producer instance.
            Each producer instance is independent from others.
            Either 'synchronized (this)' or synchronized function inside Producer, the lock is the instance itself.
            So each thread only lock itself, doesn't lock other thread, so doesn't lock other Producer.
         */

        private synchronized void produce1() {
            try {
                ++count;
                queue.put(count);
                System.out.println("Producer " + Thread.currentThread().getName() + " is producing  number " + count
                        + " ; Total product produced is " + count + " for now ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // synchronized this doesn't work
        private void produce2() {
            try {
                synchronized (this) {
                    ++count;
                    queue.put(count);
                    System.out.println("Producer " + Thread.currentThread().getName() + " is producing  number " + count
                            + " ; Total product produced is " + count + " for now ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // synchronized other object works fine
        private void produce3() {
            try {
                synchronized (LOCK) {
                    ++count;
                    queue.put(count);
                    System.out.println("Producer " + Thread.currentThread().getName() + " is producing  number " + count
                            + " ; Total product produced is " + count + " for now ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while(true) {
                sleep(1);

                // no longer need the synchronized and lock because the blocking queue helps that

//                synchronized(LOCK) {
//                    while (queue.size() == 0) {
//                        try {
//                            LOCK.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
                consume();
                }
            }
        }

        private void consume() {
            int product = 0;
            try {
                product = (int) queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("    Consumer " + Thread.currentThread().getName() + " is consuming  number " + product
                    + " ; Total product consumed is " + product + " for now ");
        }

    private static void sleep(int offset) {
        try {
            TimeUnit.SECONDS.sleep(offset);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueueStrategy bqs = new BlockingQueueStrategy();

        ExecutorService executor = Executors.newFixedThreadPool(5);
        int producerSize = 3;
        int consumerSize = 2;

        for (int i = 0; i < producerSize; i++) {
            executor.execute(bqs.new Producer());
        }

        for (int i = 0; i < consumerSize; i++) {
            executor.execute(bqs.new Consumer());
        }

        sleep(10);

//        executor.shutdown();
//        executor.shutdownNow();
    }
}
