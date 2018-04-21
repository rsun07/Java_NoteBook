package pers.xiaoming.notebook.concurrent.synchronized_and_lock.locks;

import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

public class SemaphoreTest {
    /*
        Thread[Thread-1,5,main] is Executing print.
        Thread[Thread-2,5,main] is Executing print.
        Thread[Thread-0,5,main] is Executing print.

        // wait 1s

        Thread[Thread-4,5,main] is Executing print.
        Thread[Thread-3,5,main] is Executing print.
     */
    @Test
    public void test() {
        SemaphorePrinter printer = new SemaphorePrinter(3);

        for (int i = 0; i < 5; i++) {
            new Thread(printer::print).start();
        }

        ThreadSleep.sleep(3000);
    }
}
