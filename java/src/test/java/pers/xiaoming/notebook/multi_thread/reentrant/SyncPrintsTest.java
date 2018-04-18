package pers.xiaoming.notebook.multi_thread.reentrant;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("demo tests")
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
    @Ignore("demo tests")
    public void testSynchronizedReentrant() {
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
    public void testReentrantLock() {
        ReentrantLockPrintsSub lockPrints = new ReentrantLockPrintsSub();

        System.out.println("\nFrom call Print3");
        lockPrints.print3();

        System.out.println("\nFrom call Print2");
        lockPrints.print2();

        System.out.println("\nFrom call Print1");
        lockPrints.print1();
    }
}
