package pers.xiaoming.notebook.concurrent.producer_consumer.producer_and_consumer;

import java.util.Queue;

public class DefaultConsumer {
    static int consume(Queue<Integer> queue, int count) {
        int val = queue.poll();
        count--;

        System.out.printf("Consumer %s consumes number %d, value %d\n", Thread.currentThread().getName(), count, val);
        return  count;
    }
}
