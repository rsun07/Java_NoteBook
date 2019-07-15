package pers.xiaoming.notebook.concurrent.producer_consumer_problem.producer;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer {
    public void produce(BlockingQueue<Integer> queue) {

        int val = ProducerDataSource.produceInt();

        // Don't use queue.offer(val), it WON'T blocking when queue is full!
        // it will return false and let the program moving on
        // see source code for more detail
        // boolean success = queue.offer(val);

        try {
            queue.put(val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Producer %s produces value %d, queue size is %d, \n",
                Thread.currentThread().getName(),
                val,
                queue.size());
    }
}
