package pers.xiaoming.notebook.concurrent.synchronized_and_lock.locks;

import org.junit.Test;

public class TryLockTest {
    private TryLockDemo testClass = new TryLockDemo();

    /*
        Thread[main,5,main] get lock true
        Thread[main,5,main] running get
        Thread[Thread-0,5,main] get lock false
     */
    @Test
    public void testTryLock() {
        new Thread(testClass::get).start();
        testClass.get();
    }
}
