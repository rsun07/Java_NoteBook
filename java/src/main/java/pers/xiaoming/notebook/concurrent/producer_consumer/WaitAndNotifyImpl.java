package pers.xiaoming.notebook.concurrent.producer_consumer;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;

public class WaitAndNotifyImpl implements IProducerConsumer {
    private static final String LOCK = "lock";

    public void produce(Queue<Integer> queue, final int queueSize) {
        // sleep is very important here
        // otherwise, consumer will get stuck and never go through
        ThreadSleep.sleep();
        synchronized (LOCK) {
            while (ProducerConsumerRunnable.getCount() == queueSize) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            DefaultProducer.produce(queue);
            LOCK.notifyAll();
        }
    }

    public void consume(Queue<Integer> queue, final int queueSize) {
        ThreadSleep.sleep();
        synchronized (LOCK) {
            while (ProducerConsumerRunnable.getCount() == 0) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            DefaultConsumer.consume(queue);
            LOCK.notifyAll();
        }
    }
}
