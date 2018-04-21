package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Queue;

class ProducerConsumerRunnable {

    private static int count;

    private final Queue<Integer> queue;

    private final int queueSize;

    private final IProducerConsumer producerConsumerImpl;

    ProducerConsumerRunnable(Queue<Integer> queue, final int queueSize, IProducerConsumer producerConsumerImpl) {
        this.count = 0;
        this.queue = queue;
        this.queueSize = queueSize;
        this.producerConsumerImpl = producerConsumerImpl;
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                producerConsumerImpl.produce(queue, queueSize);
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
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
