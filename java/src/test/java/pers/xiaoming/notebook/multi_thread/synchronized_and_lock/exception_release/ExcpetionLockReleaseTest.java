package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.exception_release;

import org.junit.Ignore;
import org.junit.Test;

/*

    Exception in thread "Thread-0" java.lang.ArithmeticException: / by zero
        at pers.xiaoming.notebook.multi_thread.synchronized_and_lock.exception_release.BlockPrinter.div(BlockPrinter.java:5)
        at pers.xiaoming.notebook.multi_thread.synchronized_and_lock.exception_release.ExcpetionLockReleaseTest.lambda$test$0(ExcpetionLockReleaseTest.java:10)
        at java.lang.Thread.run(Thread.java:748)

    // no waiting time here
    2 / 2 = 1

    // wait 1s here
    1 / 1 = 1

 */
@Ignore("demo tests")
public class ExcpetionLockReleaseTest {
    @Test
    public void test() throws InterruptedException {
        BlockPrinter printer = new BlockPrinter();

        Thread thread = new Thread(() -> printer.div(1, 0));
        thread.start();
        thread.join();

        printer.div(2,2);

        thread = new Thread(() -> printer.div(1, 1));
        thread.start();
        thread.join();
    }
}
