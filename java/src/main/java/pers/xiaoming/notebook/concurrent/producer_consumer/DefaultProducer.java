package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Queue;
import java.util.Random;

public class DefaultProducer {
    static void produce(Queue<Integer> queue) {
        Random random = new Random();

        int val = random.nextInt(100);
        boolean success = queue.offer(val);

        System.out.printf("Producer %s %s produces value %d, queue size is %d, \n",
                Thread.currentThread().getName(),
                success ? "successfully" : "failed to",
                val,
                queue.size());
    }
}
