package pers.xiaoming.notebook.concurrent.producer_consumer_problem;

import pers.xiaoming.notebook.concurrent.producer_consumer_problem.producer_consumer.IProducerConsumer;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;

class ProducerConsumerRunner {

    private final Queue<Integer> queue;

    private final int queueSize;

    private final IProducerConsumer producerConsumerImpl;

    ProducerConsumerRunner(Queue<Integer> queue, final int queueSize, IProducerConsumer producerConsumerImpl) {
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
}
