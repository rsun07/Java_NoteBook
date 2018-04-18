package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.synchronized_keyword;

import org.junit.Test;

public class SyncThisTest {
    private SyncThis syncThis = new SyncThis();

    /*
    print1
    // wait 1s
    print2
     */
    @Test
    public void testTwoSyncThisBlock() throws InterruptedException {

        Thread t1 = new Thread(() -> syncThis.print1());
        Thread t2 = new Thread(() -> syncThis.print2());

        t1.run();
        t2.run();
        t1.join();
        t2.join();
    }

    /*
        print1
        // wait 1s
        print2
    */
    @Test
    public void testSyncBlockWithSyncMethodSignature() throws InterruptedException {

        Thread t1 = new Thread(() -> syncThis.print1());
        Thread t2 = new Thread(() -> syncThis.print3());

        t1.run();
        t2.run();
        t1.join();
        t2.join();
    }
}
