package pers.xiaoming.notebook.concurrent.producer_consumer;

import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@Ignore("demo test, will throw exception, don't run in mvn build")
public class ProducerConsumerTest {
    private static final int PRODUCER_NUM = 3;
    private static final int CONSUMER_NUM = 2;

    private static final int QUEUE_SIZE = 10;

    private Queue<Integer> queue;
    private IProducerConsumer producerConsumerImpl;

    @Test
    public void testWaitAndNotifyImpl() {

        queue = new LinkedList<>();

        producerConsumerImpl = new WaitAndNotifyImpl();

        runTest();
    }

    @Test
    public void testConditionImpl() {

        queue = new LinkedList<>();

        producerConsumerImpl = new ConditionImpl();

        runTest();
    }

    @Test
    public void testBlockingQueueImpl() {

        queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

        producerConsumerImpl = new BlockingQueueImpl();

        runTest();
    }

    private void runTest() {
        ProducerConsumerRunnable producerConsumerRunnable = new ProducerConsumerRunnable(queue, QUEUE_SIZE, producerConsumerImpl);

        for (int i = 0; i < PRODUCER_NUM; i++) {
            new Thread(producerConsumerRunnable.new Producer()).start();
        }

        for (int i = 0; i < CONSUMER_NUM; i++) {
            new Thread(producerConsumerRunnable.new Consumer()).start();
        }

        ThreadSleep.sleepSecs(10);
    }

    /*
    If you don't sleep within the threads, here is what happending

    cpu switch thread only when pool is full of product or pool has no product.

pool-1-thread-3  Producer produce;  current count = 1
pool-1-thread-3  Producer produce;  current count = 2
pool-1-thread-3  Producer produce;  current count = 3
pool-1-thread-3  Producer produce;  current count = 4
pool-1-thread-3  Producer produce;  current count = 5
pool-1-thread-3  Producer produce;  current count = 6
pool-1-thread-3  Producer produce;  current count = 7
pool-1-thread-3  Producer produce;  current count = 8
pool-1-thread-3  Producer produce;  current count = 9
pool-1-thread-3  Producer produce;  current count = 10
pool-1-thread-1  Consumer consume;  current count = 9
pool-1-thread-1  Consumer consume;  current count = 8
pool-1-thread-1  Consumer consume;  current count = 7
pool-1-thread-1  Consumer consume;  current count = 6
pool-1-thread-1  Consumer consume;  current count = 5
pool-1-thread-1  Consumer consume;  current count = 4
pool-1-thread-1  Consumer consume;  current count = 3
pool-1-thread-1  Consumer consume;  current count = 2
pool-1-thread-1  Consumer consume;  current count = 1
pool-1-thread-1  Consumer consume;  current count = 0
pool-1-thread-2  Producer produce;  current count = 1
pool-1-thread-2  Producer produce;  current count = 2
pool-1-thread-2  Producer produce;  current count = 3
pool-1-thread-2  Producer produce;  current count = 4
pool-1-thread-2  Producer produce;  current count = 5
pool-1-thread-2  Producer produce;  current count = 6
pool-1-thread-2  Producer produce;  current count = 7
pool-1-thread-2  Producer produce;  current count = 8
pool-1-thread-2  Producer produce;  current count = 9
pool-1-thread-2  Producer produce;  current count = 10
pool-1-thread-5  Consumer consume;  current count = 9
pool-1-thread-5  Consumer consume;  current count = 8
pool-1-thread-5  Consumer consume;  current count = 7
pool-1-thread-5  Consumer consume;  current count = 6
pool-1-thread-5  Consumer consume;  current count = 5
pool-1-thread-5  Consumer consume;  current count = 4
pool-1-thread-5  Consumer consume;  current count = 3
pool-1-thread-5  Consumer consume;  current count = 2
pool-1-thread-5  Consumer consume;  current count = 1
pool-1-thread-5  Consumer consume;  current count = 0
pool-1-thread-3  Producer produce;  current count = 1
pool-1-thread-3  Producer produce;  current count = 2
pool-1-thread-3  Producer produce;  current count = 3
pool-1-thread-3  Producer produce;  current count = 4
pool-1-thread-3  Producer produce;  current count = 5
pool-1-thread-3  Producer produce;  current count = 6
pool-1-thread-3  Producer produce;  current count = 7
pool-1-thread-3  Producer produce;  current count = 8
pool-1-thread-3  Producer produce;  current count = 9
pool-1-thread-3  Producer produce;  current count = 10
 */
}
