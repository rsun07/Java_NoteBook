package pers.xiaoming.notebook.concurrent.interaction;

import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Ignore("demo test, don't run on mvn")
public class ConditionTest {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    /*
        Thread[Thread-0,5,main] is Waiting for notification!
        Thread[Thread-1,5,main] is Waiting for notification!
        Thread[Thread-2,5,main] is Notifying!
        Thread[Thread-0,5,main] is notified!
        Thread[Thread-3,5,main] is Notifying!
        Thread[Thread-1,5,main] is notified!
     */
    @Test
    public void testWaitAndNotify() {

        new Thread(this::threadWait).start();
        new Thread(this::threadWait).start();
        ThreadSleep.sleep(10);
        new Thread(this::threadNotify).start();
        new Thread(this::threadNotify).start();
    }

    /*
        Thread[Thread-0,5,main] is Waiting for notification!
        Thread[Thread-1,5,main] is Waiting for notification!
        Thread[Thread-2,5,main] is Notifying!
        Thread[Thread-0,5,main] is notified!
     */
    @Test
    public void testTwoWaitsAndOnlyOneNotify() {
        new Thread(this::threadWait).start();
        new Thread(this::threadWait).start();
        ThreadSleep.sleep(10);
        new Thread(this::threadNotify).start();
    }

    /*
        Thread[Thread-0,5,main] is Waiting for notification!
        Thread[Thread-1,5,main] is Waiting for notification!
        Thread[Thread-2,5,main] is Notifying!
        Thread[Thread-1,5,main] is notified!
        Thread[Thread-0,5,main] is notified!
     */
    @Test
    public void testTwoWaitsAndNotifyAll() {
        new Thread(this::threadWait).start();
        new Thread(this::threadWait).start();
        ThreadSleep.sleep(10);
        new Thread(this::threadNotifyAll).start();
    }

    private void threadWait() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread() + " is Waiting for notification!");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread() + " is notified!");
            lock.unlock();
        }

    }

    private void threadNotify() {
        System.out.println(Thread.currentThread() + " is Notifying!");

        lock.lock();

        try {
            condition.signal();
        } finally {
            lock.unlock();
        }

    }

    private void threadNotifyAll() {
        System.out.println(Thread.currentThread() + " is Notifying ALL!");

        lock.lock();

        try {
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
