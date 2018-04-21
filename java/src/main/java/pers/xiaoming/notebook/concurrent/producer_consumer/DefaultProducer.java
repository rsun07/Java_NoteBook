package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Queue;
import java.util.Random;

public class DefaultProducer {
    static int produce(Queue<Integer> queue, int count) {
        Random random = new Random();

        int val = random.nextInt(100);
        queue.offer(val);

        count++;

        System.out.printf("Producer %s produces number %d, value %d\n", Thread.currentThread().getName(), count, val);
        return count;
    }
}
