package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer {
    static void produce(BlockingQueue<Integer> queue) {
        Random random = new Random();

        int val = random.nextInt(100);
        queue.offer(val);

        System.out.printf("Producer %s produces value %d, queue size is %d, \n", Thread.currentThread().getName(), val, queue.size());
    }
}
