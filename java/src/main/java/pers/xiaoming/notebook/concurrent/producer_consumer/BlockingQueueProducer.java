package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer {
    static void produce(BlockingQueue<Integer> queue) {

        int val = ProducerSource.produceInt();

        boolean success = queue.offer(val);

        System.out.printf("Producer %s %s produces value %d, queue size is %d, \n",
                Thread.currentThread().getName(),
                success ? "successfully" : "failed to",
                val,
                queue.size());
    }
}
