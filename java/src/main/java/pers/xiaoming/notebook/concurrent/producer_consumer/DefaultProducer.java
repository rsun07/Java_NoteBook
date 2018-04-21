package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Queue;
import java.util.Random;

public class DefaultProducer {
    static void produce(Queue<Integer> queue) {
        Random random = new Random();

        int val = random.nextInt(100);
        queue.offer(val);

        System.out.printf("Producer %s produces number %d, value %d\n", Thread.currentThread().getName(), ProducerConsumerRunnable.getCount(), val);

        ProducerConsumerRunnable.addCount();
    }
}
