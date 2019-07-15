package pers.xiaoming.notebook.concurrent.producer_consumer_problem.producer_consumer;

import java.util.Queue;

public interface IProducerConsumer {
    void produce(Queue<Integer> queue, final int queueSize);

    void consume(Queue<Integer> queue, final int queueSize);
}
