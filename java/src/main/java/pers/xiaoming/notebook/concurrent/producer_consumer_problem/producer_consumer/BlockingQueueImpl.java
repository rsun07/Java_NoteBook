package pers.xiaoming.notebook.concurrent.producer_consumer_problem.producer_consumer;

import pers.xiaoming.notebook.concurrent.producer_consumer_problem.consumer.BlockingQueueConsumer;
import pers.xiaoming.notebook.concurrent.producer_consumer_problem.producer.BlockingQueueProducer;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueImpl implements IProducerConsumer {
    private BlockingQueueProducer producer;
    private BlockingQueueConsumer consumer;

    public BlockingQueueImpl() {
        this.producer = new BlockingQueueProducer();
        this.consumer = new BlockingQueueConsumer();
    }

    public void produce(Queue<Integer> queue, final int queueSize) {
        BlockingQueue<Integer> blockingQueue = queueCheck(queue);

        producer.produce(blockingQueue);
    }

    public void consume(Queue<Integer> queue, final int queueSize) {
        BlockingQueue<Integer> blockingQueue = queueCheck(queue);

        ThreadSleep.sleep();
        consumer.consume(blockingQueue);
    }

    private BlockingQueue<Integer> queueCheck(Queue<Integer> queue) {
        if (!(queue instanceof BlockingQueue)) {
            throw new RuntimeException("Must be blocking queue!");
        }
        return (BlockingQueue<Integer>) queue;
    }
}
