package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer {
    static void consume(BlockingQueue<Integer> queue) {
        // Don't use queue.poll(), it WON'T block the program when queue is empty
        // It will return false and let the program moving on
        // int val = queue.poll();

        // use take() instead to block
        int val = 0;
        try {
            val = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Consumer %s consumes value %d, queue size is %d, \n", Thread.currentThread().getName(), val, queue.size());
    }
}
