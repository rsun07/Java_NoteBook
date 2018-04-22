package pers.xiaoming.notebook.concurrent.producer_consumer;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;

public class WaitAndNotifyImpl implements IProducerConsumer {
    private static final String LOCK = "lock";

    public void produce(Queue<Integer> queue, final int queueSize) {
        synchronized (LOCK) {
            while (queue.size() == queueSize) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    LOCK.notifyAll();
                }
            }
            DefaultProducer.produce(queue);
            LOCK.notifyAll();
        }
    }

    public void consume(Queue<Integer> queue, final int queueSize) {
        // sleep is very important here
        // otherwise, consumer will get stuck and never go through
        ThreadSleep.sleep();
        synchronized (LOCK) {
            while (queue.size() == 0) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    LOCK.notifyAll();
                }
            }
            DefaultConsumer.consume(queue);
            LOCK.notifyAll();
        }
    }
}
