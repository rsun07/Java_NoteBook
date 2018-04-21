package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class WaitNotifyImpl {

    // config for producer comsumer
    private static int count = 0;
    private static final int QUEUE_SIZE = 10;
    private static final String LOCK = "lock";

    private static Queue<Integer> queue = new LinkedList<>();

    private static Random random = new Random();

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                // sleep is very important here
                // otherwise, consumer will get stuck and never go through
                sleep();
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
            int val = random.nextInt(100);
            queue.offer(val);

            count++;

            System.out.printf("Producer %s produces number %d, value %d\n", Thread.currentThread().getName(), count, val);
            LOCK.notifyAll();
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                sleep();
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
            int val = queue.poll();
            count--;

            System.out.printf("Consumer %s consumes number %d, value %d\n", Thread.currentThread().getName(), count, val);
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


}
