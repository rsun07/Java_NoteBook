package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Queue;

public class DefaultConsumer {
    static void consume(Queue<Integer> queue) {
        int val = queue.poll();

        System.out.printf("Consumer %s consumes number %d, value %d\n", Thread.currentThread().getName(), ProducerConsumerRunnable.getCount(), val);

        ProducerConsumerRunnable.subCount();
    }
}
