package pers.xiaoming.notebook.multi_thread.synchronized_.reentrant;

import org.junit.Test;

public class SyncPrintsTest {

    /*
        From call Print3
        print3
        print2
        print1

        // sleep 1s
        From call Print2
        print2
        print1

        // sleep 1s
        From call Print1
        print1
    */
    @Test
    public void test() throws InterruptedException {
        SyncPrintsSub syncPrints = new SyncPrintsSub();
        System.out.println("\nFrom call Print3");
        syncPrints.print3();

        System.out.println("\nFrom call Print2");
        syncPrints.print2();

        System.out.println("\nFrom call Print1");
        syncPrints.print1();
    }

    /*
        From call Print3
        print3
        print2
        print1

        // sleep 1s
        From call Print2
        print2
        print1

        // sleep 1s
        From call Print1
        print1
     */
    @Test
    public void testReentrantLockFail() throws InterruptedException {
        ReentrantLockPrintsSub lockPrints = new ReentrantLockPrintsSub();

        System.out.println("\nFrom call Print3");
        lockPrints.print3();

        System.out.println("\nFrom call Print2");
        lockPrints.print2();

        System.out.println("\nFrom call Print1");
        lockPrints.print1();
    }
}
