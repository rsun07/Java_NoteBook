package pers.xiaoming.notebook.concurrent.synchronized_and_lock.synchronized_keyword;

import org.junit.Ignore;
import org.junit.Test;

// synchronized (this) {}
// is still object block
// block all other method and block in one object
@Ignore("demo tests")
public class SyncNonThisTest {
    private SyncNonThis syncNonThis = new SyncNonThis();

    /*
        no waiting time

        Thread[Thread-0,5,main] Trying to access print 1 sync block
        print1
        Thread[Thread-1,5,main] Trying to access print 2 sync block
        print2
     */
    @Test
    public void testNotBlock() throws InterruptedException {

        Thread t1 = new Thread(syncNonThis::print1);
        Thread t2 = new Thread(syncNonThis::print2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /*
        Thread[Thread-0,5,main] Trying to access print 2 sync block
        Thread[Thread-1,5,main] Trying to access print 3 sync block
        Lock is : [I@52945789
        print2

        // wait 1s

        Lock is : [I@52945789
        print3
    */
    @Test
    public void testLockObjChangeValue() throws InterruptedException {
        Thread t1 = new Thread(syncNonThis::print2);
        Thread t2 = new Thread(syncNonThis::print3);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
