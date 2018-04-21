package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Queue;

public interface IProducerConsumer {
    int produce(Queue<Integer> queue, int count, final int queueSize);

    int consume(Queue<Integer> queue, int count, final int queueSize);
}
