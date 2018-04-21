package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Queue;

class ProducerConsumerRunnable {

    private static int count = 0;

    private final Queue<Integer> queue;

    private final int queueSize;

    private final IProducerConsumer producerConsumerImpl;

    ProducerConsumerRunnable(Queue<Integer> queue, final int queueSize, IProducerConsumer producerConsumerImpl) {
        this.queue = queue;
        this.queueSize = queueSize;
        this.producerConsumerImpl = producerConsumerImpl;
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                count = producerConsumerImpl.produce(queue, queueSize, count);
            }
        }


    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                count = producerConsumerImpl.consume(queue, queueSize, count);
            }
        }
    }
}
