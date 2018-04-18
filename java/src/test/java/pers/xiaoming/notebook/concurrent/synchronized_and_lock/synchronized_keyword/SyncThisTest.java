package pers.xiaoming.notebook.concurrent.synchronized_and_lock.synchronized_keyword;

import org.junit.Ignore;
import org.junit.Test;

// synchronized (this) {}
// is still object block
// block all other method and block in one object
@Ignore("demo tests")
public class SyncThisTest {
    private SyncThis syncThis = new SyncThis();

    /*
    Thread[Thread-0,5,main] Trying to access print 1 sync block
    print1
    Thread[Thread-1,5,main] Trying to access print 2 sync block

    // wait 1s

    print2

     */
    @Test
    public void testTwoSyncThisBlock() throws InterruptedException {

        Thread t1 = new Thread(syncThis::print1);
        Thread t2 = new Thread(syncThis::print2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /*
        Thread[Thread-0,5,main] Trying to access print 1 sync block
        Thread[Thread-1,5,main] Trying to access print 3 sync block
        print3

        // wait 1s

        print1
    */
    @Test
    public void testSyncBlockWithSyncMethodSignature() throws InterruptedException {

        Thread t1 = new Thread(syncThis::print1);
        Thread t2 = new Thread(syncThis::print3);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /*
        no waiting time

        Thread[Thread-0,5,main] Trying to access print 1 sync block
        print1
        Thread[Thread-1,5,main] Trying to access print 2 sync block
        print2
    */
    @Test
    public void testTwoSyncThisBlockTwoObject() throws InterruptedException {
        SyncThis syncThisCopy = new SyncThis();

        Thread t1 = new Thread(syncThis::print1);
        Thread t2 = new Thread(syncThisCopy::print2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
