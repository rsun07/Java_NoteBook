package pers.xiaoming.notebook.concurrent.producer_consumer_problem.producer_consumer;

import pers.xiaoming.notebook.concurrent.producer_consumer_problem.consumer.DefaultConsumer;
import pers.xiaoming.notebook.concurrent.producer_consumer_problem.producer.DefaultProducer;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionImpl implements IProducerConsumer {
    private final Lock lock;
    private final Condition condition;

    private DefaultProducer producer;
    private DefaultConsumer consumer;

    public ConditionImpl() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();

        this.producer = new DefaultProducer();
        this.consumer = new DefaultConsumer();
    }

    public void produce(Queue<Integer> queue, final int queueSize) {
        lock.lock();
        try {
            while (queue.size() == queueSize) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            producer.produce(queue);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume(Queue<Integer> queue, final int queueSize) {
        ThreadSleep.sleep();
        lock.lock();
        try {
            while (queue.size() == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            consumer.consume(queue);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
