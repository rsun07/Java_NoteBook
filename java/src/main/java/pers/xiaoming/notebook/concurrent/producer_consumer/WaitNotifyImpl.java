package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.concurrent.TimeUnit;

class WaitNotifyImpl {

    // config for producer comsumer
    private static int count = 0;
    private static final int QUEUE_SIZE = 10;
    private static final String LOCK = "lock";

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


}
