package pers.xiaoming.notebook.concurrent.producer_consumer.producer_and_consumer;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionImpl implements IProducerConsumer {
    private final Lock lock;
    private final Condition condition;

    public ConditionImpl() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public int produce(Queue<Integer> queue, int count, final int queueSize) {
        // sleep is very important here
        // otherwise, consumer will get stuck and never go through
        ThreadSleep.sleep();
        lock.lock();
        try {
            while (count == queueSize) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count = DefaultProducer.produce(queue, count);
            condition.signalAll();
            return count;
        } finally {
            lock.unlock();
        }
    }

    public int consume(Queue<Integer> queue, int count, final int queueSize) {
        ThreadSleep.sleep();
        lock.lock();
        try {
            while (count == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count = DefaultConsumer.consume(queue, count);
            condition.signalAll();
            return count;
        } finally {
            lock.unlock();
        }
    }
}
