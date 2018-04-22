package pers.xiaoming.notebook.concurrent.producer_consumer;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueImpl implements IProducerConsumer {

    public void produce(Queue<Integer> queue, final int queueSize) {
        BlockingQueue<Integer> blockingQueue = queueCheck(queue);

        BlockingQueueProducer.produce(blockingQueue);
    }

    public void consume(Queue<Integer> queue, final int queueSize) {
        BlockingQueue<Integer> blockingQueue = queueCheck(queue);

        ThreadSleep.sleep();
        BlockingQueueConsumer.consume(blockingQueue);
    }

    private BlockingQueue<Integer> queueCheck(Queue<Integer> queue) {
        if (!(queue instanceof BlockingQueue)) {
            throw new RuntimeException("Must be blocking queue!");
        }
        return (BlockingQueue<Integer>) queue;
    }
}
