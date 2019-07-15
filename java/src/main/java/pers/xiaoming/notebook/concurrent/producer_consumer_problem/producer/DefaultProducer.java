package pers.xiaoming.notebook.concurrent.producer_consumer_problem.producer;

import java.util.Queue;

public class DefaultProducer {
    public void produce(Queue<Integer> queue) {

        int val = ProducerDataSource.produceInt();

        boolean success = queue.offer(val);

        System.out.printf("Producer %s %s produces value %d, queue size is %d, \n",
                Thread.currentThread().getName(),
                success ? "successfully" : "failed to",
                val,
                queue.size());
    }
}
