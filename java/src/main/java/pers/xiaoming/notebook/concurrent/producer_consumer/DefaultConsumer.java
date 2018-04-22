package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Queue;

public class DefaultConsumer {
    static void consume(Queue<Integer> queue) {
        int val = queue.poll();

        System.out.printf("Consumer %s consumes value %d, queue size is %d, \n",
                Thread.currentThread().getName(), val, queue.size());
    }
}
