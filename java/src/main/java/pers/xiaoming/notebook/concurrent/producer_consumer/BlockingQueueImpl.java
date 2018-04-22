package pers.xiaoming.notebook.concurrent.producer_consumer;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueImpl implements IProducerConsumer {

    public void produce(Queue<Integer> queue, final int queueSize) {
        queueCheck(queue);

        ThreadSleep.sleep();
        while (ProducerConsumerRunnable.getCount() == queueSize) {
            DefaultProducer.produce(queue);
        }
    }

    public void consume(Queue<Integer> queue, final int queueSize) {
        queueCheck(queue);

        ThreadSleep.sleep();
        while (ProducerConsumerRunnable.getCount() == 0) {
            DefaultConsumer.consume(queue);
        }
    }

    private void queueCheck(Queue<Integer> queue) {
        if (!(queue instanceof BlockingQueue)) {
            throw new RuntimeException("Must be blocking queue!");
        }
    }
}
