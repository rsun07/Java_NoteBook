package pers.xiaoming.notebook.concurrent.interaction;

import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

@Ignore("demo test, don't run on mvn")
public class WaitNotifyTest {
    private static final String LOCK = "lock";

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

        synchronized (LOCK) {
            try {
                System.out.println(Thread.currentThread() + " is Waiting for notification!");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread() + " is notified!");
        }
    }

    private void threadNotify() {
        System.out.println(Thread.currentThread() + " is Notifying!");

        synchronized (LOCK) {
            LOCK.notify();
        }
    }

    private void threadNotifyAll() {
        System.out.println(Thread.currentThread() + " is Notifying!");

        synchronized (LOCK) {
            LOCK.notifyAll();
        }
    }
}
