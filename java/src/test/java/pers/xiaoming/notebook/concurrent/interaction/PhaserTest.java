package pers.xiaoming.notebook.concurrent.interaction;

import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

@Ignore("demo test, don't run in maven build")
public class PhaserTest {

    // through debug mode
    // phase number index start from 0 rather than 1
    private Phaser phaser = new Phaser(2);

    // count down latch is for main thread to wait for full console prints
    private CountDownLatch countDownLatch = new CountDownLatch(2);

    /*
        Thread[Thread-0,5,main] Executing Faster Phase 1
        // wait 1s
        Thread[Thread-1,5,main] Executing Slow Phase 1
        Thread[Thread-1,5,main] Executing Faster Phase 2

        // wait 3s
        Thread[Thread-0,5,main] Executing Super Slow Phase 2
        Thread[Thread-0,5,main] DONE!
        Thread[Thread-1,5,main] DONE!
        Thread[main,5,main] DONE!
     */
    @Test
    public void testArriveAndAwaitAdvance() throws InterruptedException {
        new Thread(
            () -> {
                fasterPhase1();
                phaser.arriveAndAwaitAdvance();
                superSlowPhase2();
                phaser.arriveAndAwaitAdvance();

                countDownLatch.countDown();
                threadDone();
            }
        ).start();

        new Thread(
            () -> {
                slowerPhase1();
                phaser.arriveAndAwaitAdvance();
                fasterPhase2();
                phaser.arriveAndAwaitAdvance();

                countDownLatch.countDown();
                threadDone();
            }
        ).start();

        countDownLatch.await();
        threadDone();
    }

    /*
        Thread[Thread-0,5,main] Executing Faster Phase 1
        // wait 1s
        Thread[Thread-1,5,main] Executing Slow Phase 1
        Thread[Thread-1,5,main] Executing Faster Phase 2
        Thread[Thread-1,5,main] DONE!

        // wait 3s
        Thread[Thread-0,5,main] Executing Super Slow Phase 2
        Thread[Thread-0,5,main] DONE!
        Thread[main,5,main] DONE!
     */

    @Test
    public void testArriveAndDeregister() throws InterruptedException {
        new Thread(
            () -> {
                fasterPhase1();
                phaser.arriveAndAwaitAdvance();
                superSlowPhase2();
                phaser.arriveAndAwaitAdvance();

                countDownLatch.countDown();
                threadDone();
            }
        ).start();

        new Thread(
                () -> {
                slowerPhase1();
                phaser.arriveAndDeregister();
                // won't wait, because already de-register
                fasterPhase2();
                phaser.arriveAndAwaitAdvance();

                countDownLatch.countDown();
                threadDone();
            }
        ).start();

        countDownLatch.await();
        threadDone();
    }

    /*
        Thread[Thread-0,5,main] Executing Faster Phase 1

        // wait 1s

        Thread[Thread-1,5,main] Executing Slow Phase 1
        Thread[Thread-1,5,main] Executing Faster Phase 2

        // wait 3s here

        Thread[Thread-0,5,main] Executing Super Slow Phase 2
        Thread[Thread-0,5,main] DONE!
        Thread[Thread-1,5,main] DONE!
        Thread[main,5,main] DONE!
     */

    // if there is no "phaser.awaitAdvance(phaseNum+1);"
    // Thread[Thread-1,5,main] DONE!    will happen before         Thread[Thread-0,5,main] Executing Super Slow Phase 2
    @Test
    public void testAwaitAdvance() throws InterruptedException {
        new Thread(
                () -> {
                    fasterPhase1();
                    phaser.arriveAndAwaitAdvance();
                    superSlowPhase2();
                    phaser.arriveAndAwaitAdvance();

                    countDownLatch.countDown();
                    threadDone();
                }
        ).start();

        new Thread(
                () -> {
                    slowerPhase1();
                    int phaseNum = phaser.arriveAndDeregister();
                    // won't wait, because already de-register
                    fasterPhase2();
                    phaser.awaitAdvance(phaseNum+1);

                    countDownLatch.countDown();
                    threadDone();
                }
        ).start();

        countDownLatch.await();
        threadDone();
    }


    private void fasterPhase1() {
        System.out.println(Thread.currentThread() + " Executing Faster Phase 1");
    }

    private void slowerPhase1() {
        ThreadSleep.sleep();
        System.out.println(Thread.currentThread() + " Executing Slow Phase 1");
    }

    private void fasterPhase2() {
        System.out.println(Thread.currentThread() + " Executing Faster Phase 2");
    }

    private void superSlowPhase2() {
        ThreadSleep.sleep(3000);
        System.out.println(Thread.currentThread() + " Executing Super Slow Phase 2");
    }

    private void threadDone() {
        System.out.println(Thread.currentThread() + " DONE!");
    }
}
