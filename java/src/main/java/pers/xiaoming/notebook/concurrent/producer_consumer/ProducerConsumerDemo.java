package pers.xiaoming.notebook.concurrent.producer_consumer;

import pers.xiaoming.notebook.concurrent.producer_consumer.producer_and_consumer.IProducerConsumer;

import java.util.Queue;

class ProducerConsumerDemo {

    private static int count = 0;

    private final Queue<Integer> queue;

    private final int queueSize;

    private final IProducerConsumer producerConsumerImpl;

    ProducerConsumerDemo(Queue<Integer> queue, final int queueSize, IProducerConsumer producerConsumerImpl) {
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
