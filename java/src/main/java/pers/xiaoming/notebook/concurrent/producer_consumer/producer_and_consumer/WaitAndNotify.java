package pers.xiaoming.notebook.concurrent.producer_consumer.producer_and_consumer;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;

public class WaitAndNotify implements IProducerConsumer {
    private static final String LOCK = "lock";

    public int produce(Queue<Integer> queue, int count, final int queueSize) {
        // sleep is very important here
        // otherwise, consumer will get stuck and never go through
        ThreadSleep.sleep();
        synchronized (LOCK) {
            while (count == queueSize) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count = DefaultProducer.produce(queue, count);
            LOCK.notifyAll();
            return count;
        }
    }

    public int consume(Queue<Integer> queue, int count, final int queueSize) {
        ThreadSleep.sleep();
        synchronized (LOCK) {
            while (count == 0) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count = DefaultConsumer.consume(queue, count);
            LOCK.notifyAll();
            return count;
        }
    }
}
