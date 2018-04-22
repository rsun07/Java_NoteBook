package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Queue;
import java.util.Random;

public class DefaultProducer {
    static void produce(Queue<Integer> queue) {
        Random random = new Random();

        int val = random.nextInt(100);
        queue.offer(val);

        System.out.printf("Producer %s produces value %d, queue size is %d, \n", Thread.currentThread().getName(), val, ProducerConsumerRunnable.getCount());

        ProducerConsumerRunnable.addCount();
    }
}
