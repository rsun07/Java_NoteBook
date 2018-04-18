package pers.xiaoming.notebook.concurrent.synchronized_and_lock.locks;

import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

public class ReadWriteLockTest {
    private ReadWriteLockDemo testClass = new ReadWriteLockDemo();

    /*
    // no wait time
        Thread[main,5,main] is accessing READ
        Thread[Thread-0,5,main] is accessing READ
     */
    @Test
    public void testTwoRead() {
        new Thread(testClass::read).start();
        testClass.read();
    }

    /*
        Thread[main,5,main] is accessing WRITE
        // wait 1s
        Thread[Thread-0,5,main] is accessing WRITE
    */
    @Test
    public void testTwoWrite() {
        new Thread(testClass::write).start();
        testClass.write();
    }

    /*
        Thread[Thread-0,5,main] is accessing READ
        // wait 1s
        Thread[main,5,main] is accessing WRITE
    */
    @Test
    public void testReadThenWrite() {
        new Thread(testClass::read).start();
        ThreadSleep.sleep(1);
        testClass.write();
    }

    /*
        Thread[Thread-0,5,main] is accessing WRITE
        // wait 1s
        Thread[main,5,main] is accessing READ
    */
    @Test
    public void testWriteThenRead() {
        new Thread(testClass::write).start();
        ThreadSleep.sleep(1);
        testClass.read();
    }
}
