package pers.xiaoming.notebook.concurrent.producer_consumer;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionImpl implements IProducerConsumer {
    private final Lock lock;
    private final Condition condition;

    ConditionImpl() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void produce(Queue<Integer> queue, final int queueSize) {
        // sleep is very important here
        // otherwise, consumer will get stuck and never go through
        ThreadSleep.sleep();
        lock.lock();
        try {
            while (ProducerConsumerRunnable.getCount() == queueSize) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            DefaultProducer.produce(queue);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume(Queue<Integer> queue, final int queueSize) {
        ThreadSleep.sleep();
        lock.lock();
        try {
            while (ProducerConsumerRunnable.getCount() == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            DefaultConsumer.consume(queue);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
