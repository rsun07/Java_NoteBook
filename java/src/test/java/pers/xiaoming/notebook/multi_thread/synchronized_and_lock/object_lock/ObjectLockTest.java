package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.object_lock;

import org.junit.Ignore;
import org.junit.Test;

// prove that synchronized in method signature is object lock
// the lock is the object

// static methods use class lock, different from object lock
@Ignore("demo tests")
public class ObjectLockTest {
    private SyncMethodDemo testClass = new SyncMethodDemo();


    /*
    // no waiting time
        Executing Non Synchronized Method
        Executing Synchronized Method
     */
    @Test
    public void testSyncOneMethod() throws InterruptedException {

        Thread t1 = new Thread(testClass::nonSyncMethod);
        Thread t2 = new Thread(testClass::syncMethod);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /*
        Executing Synchronized Method

        // wait 500ms
        Executing Synchronized Method Copy
     */
    @Test
    public void testSyncBothMethods() throws InterruptedException {
        Thread t1 = new Thread(testClass::syncMethod);
        Thread t2 = new Thread(testClass::syncMethodCopy);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /*
    // no waiting time
        Executing Synchronized Method
        Executing Synchronized Method
     */
    @Test
    public void testSyncTwoMethodTwoObject() throws InterruptedException {
        SyncMethodDemo testClassCopy = new SyncMethodDemo();

        Thread t1 = new Thread(testClass::syncMethod);
        Thread t2 = new Thread(testClassCopy::syncMethod);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /*
    // no waiting time
        Executing Synchronized Method
        // wait 500ms
        Executing Static Synchronized Method
     */
    @Test
    public void testOneSyncStaticMethod() throws InterruptedException {
        Thread t1 = new Thread(testClass::syncMethod);
        Thread t2 = new Thread(SyncMethodDemo::staticSyncMethod);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /*
    // no waiting time
        Executing Synchronized Method
        Executing Static Synchronized Method Copy
     */
    @Test
    public void testBothSyncStaticMethod() throws InterruptedException {
        Thread t1 = new Thread(SyncMethodDemo::staticSyncMethod);
        Thread t2 = new Thread(SyncMethodDemo::staticSyncMethodCopy);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
