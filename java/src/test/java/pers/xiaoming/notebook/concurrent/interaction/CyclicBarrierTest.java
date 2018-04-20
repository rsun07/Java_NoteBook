package pers.xiaoming.notebook.concurrent.interaction;

import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    private CyclicBarrier barrier = new CyclicBarrier(5);

    /*

    Thread[Thread-0,5,main] is executing.
    Thread[Thread-1,5,main] is executing.
    Thread[Thread-2,5,main] is executing.

    // wait 1s
    Thread[Thread-3,5,main] is executing.

     */
    @Test
    public void testCyclicBarrier() {
        test();
    }

    /*

        Thread[Thread-0,5,main] is executing.
        Thread[Thread-1,5,main] is executing.
        Thread[Thread-2,5,main] is executing.

        // wait 1s
        Thread[Thread-3,5,main] is executing.

        // no wait time
        Reset barrier

        Thread[Thread-0,5,main] is executing.
        Thread[Thread-1,5,main] is executing.
        Thread[Thread-2,5,main] is executing.

        // wait 1s
        Thread[Thread-3,5,main] is executing.

     */
    @Test
    public void testRest() {
        test();
        barrier.reset();
        System.out.println("\nReset barrier\n");
        test();
    }

    private void test() {
        new Thread(this::faster).start();
        new Thread(this::faster).start();
        new Thread(this::faster).start();
        new Thread(this::slower).start();

        // this is for main thread wait all thread done.
        // but the difference between DownCountLatch and CyclicBarrier is
        // DownCountLatch is mainly for one thread wait all others
        // CyclicBarrier is for all thread to wait for an event
        barrierWait();
    }

    private void faster() {
        System.out.println(Thread.currentThread() + " is executing.");

        barrierWait();
    }

    private void slower() {
        ThreadSleep.sleep(500);

        System.out.println(Thread.currentThread() + " is executing.");

        barrierWait();
    }

    private void barrierWait() {
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


}
