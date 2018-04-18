package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.object_lock;

import org.junit.Ignore;
import org.junit.Test;

// prove that synchronized in method signature is object lock
// the lock is the object
@Ignore("demo tests")
public class ObjectLockTest {

    /*
        Executing Method A
        Executing Method B
        Executing Method B
        Executing Method B

        // wait 1s After B finish to finish
        Executing Method A
        Executing Method A
     */
    @Test
    public void testSyncOneMethod() throws InterruptedException {
        IObjectLock testClass = new SyncOneMethod();

        Thread t1 = new Thread(() -> runA(testClass));
        Thread t2 = new Thread(() -> runB(testClass));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /*
        Executing Method A
        // wait 500ms
        Executing Method A
        // wait 500ms
        Executing Method A
        // finish very fast!
        Executing Method B
        Executing Method B
        Executing Method B
     */
    @Test
    public void testSyncTwoMethod() throws InterruptedException {
        IObjectLock testClass = new SyncBothMethod();

        Thread t1 = new Thread(() -> runA(testClass));
        Thread t2 = new Thread(() -> runB(testClass));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /*
    Same result as testSyncOneMethod()
        Executing Method A
        Executing Method B
        Executing Method B
        Executing Method B
        // wait 500 ms
        Executing Method A
        // wait 500ms
        Executing Method A
     */
    @Test
    public void testSyncTwoMethodTwoObject() throws InterruptedException {
        IObjectLock testClassA = new SyncBothMethod();
        IObjectLock testClassB = new SyncBothMethod();

        Thread t1 = new Thread(() -> runA(testClassA));
        Thread t2 = new Thread(() -> runB(testClassB));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    void runA(IObjectLock testClass) {
        for (int i = 0; i < 3; i++) {
            testClass.methodA();
        }
    }

    void runB(IObjectLock testClass) {
        for (int i = 0; i < 3; i++) {
            testClass.methodB();
        }
    }
}
