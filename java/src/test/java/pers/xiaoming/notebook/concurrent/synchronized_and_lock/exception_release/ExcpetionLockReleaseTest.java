package pers.xiaoming.notebook.concurrent.synchronized_and_lock.exception_release;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("demo tests")
public class ExcpetionLockReleaseTest {

    /*
        Exception in thread "Thread-0" java.lang.ArithmeticException: / by zero
            at pers.xiaoming.notebook.guava.synchronized_and_lock.exception_release.BlockPrinter.syncDiv(BlockPrinter.java:5)
            at pers.xiaoming.notebook.guava.synchronized_and_lock.exception_release.ExcpetionLockReleaseTest.lambda$test$0(ExcpetionLockReleaseTest.java:10)
            at java.lang.Thread.run(Thread.java:748)

        // no waiting time here
        2 / 2 = 1

        // wait 1s here
        1 / 1 = 1
    */

    @Test
    public void testSynchronizedRelease() throws InterruptedException {
        BlockPrinter printer = new BlockPrinter();

        Thread thread = new Thread(() -> printer.syncDiv(1, 0));
        thread.start();
        thread.join();

        printer.syncDiv(2,2);

        thread = new Thread(() -> printer.syncDiv(1, 1));
        thread.start();
        thread.join();
    }

    /*
        Exception in thread "Thread-0" java.lang.ArithmeticException: / by zero
            at pers.xiaoming.notebook.guava.synchronized_and_lock.exception_release.BlockPrinter.poorLockDiv(BlockPrinter.java:25)
            at pers.xiaoming.notebook.guava.synchronized_and_lock.exception_release.ExcpetionLockReleaseTest.lambda$testLockFailToRelease$2(ExcpetionLockReleaseTest.java:41)
            at java.lang.Thread.run(Thread.java:748)

        And main thread get blocked, never go through until test timeout

        org.junit.runners.model.TestTimedOutException: test timed out after 3000 milliseconds

     */
    @Test(timeout = 3000)
    public void testLockFailToRelease() throws InterruptedException {
        BlockPrinter printer = new BlockPrinter();

        Thread thread = new Thread(() -> printer.poorLockDiv(1, 0));
        thread.start();
        thread.join();

        printer.poorLockDiv(2,2);

        thread = new Thread(() -> printer.poorLockDiv(1, 1));
        thread.start();
        thread.join();
    }

    // same result as the synchronized release test
    @Test
    public void testLockRelease() throws InterruptedException {
        BlockPrinter printer = new BlockPrinter();

        Thread thread = new Thread(() -> printer.lockDiv(1, 0));
        thread.start();
        thread.join();

        printer.poorLockDiv(2,2);

        thread = new Thread(() -> printer.lockDiv(1, 1));
        thread.start();
        thread.join();
    }
}
