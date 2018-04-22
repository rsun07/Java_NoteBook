package pers.xiaoming.notebook.concurrent.producer_consumer;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;

class ProducerConsumerRunnable {

    private static int count;

    private final Queue<Integer> queue;

    private final int queueSize;

    private final IProducerConsumer producerConsumerImpl;

    ProducerConsumerRunnable(Queue<Integer> queue, final int queueSize, IProducerConsumer producerConsumerImpl) {
        count = 0;
        this.queue = queue;
        this.queueSize = queueSize;
        this.producerConsumerImpl = producerConsumerImpl;
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                ThreadSleep.sleep500();
                producerConsumerImpl.produce(queue, queueSize);
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            ThreadSleep.sleep(10);
            while (true) {
                ThreadSleep.sleep500();
                producerConsumerImpl.consume(queue, queueSize);
            }
        }
    }

    static void addCount() {
        synchronized (ProducerConsumerRunnable.class) {
            count++;
        }
    }

    static void subCount() {
        synchronized (ProducerConsumerRunnable.class) {
            count--;
        }
    }

    static int getCount() {
        synchronized (ProducerConsumerRunnable.class) {
            return count;
        }
    }
}
