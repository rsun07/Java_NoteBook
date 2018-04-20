package pers.xiaoming.notebook.lang.keywords;

import org.junit.Ignore;
import org.junit.Test;

public class FinallyTest {
    @Test(expected = RuntimeException.class)
    public void testException() {
        try {
            System.out.println(Thread.currentThread() + "Try thread");
            throw new RuntimeException("Exception throw");
        } catch (Exception e) {
            System.out.println(Thread.currentThread() + "Catch thread");
            throw e;
        } finally {
            System.out.println(Thread.currentThread() + "FinallyTest thread");
        }
    }

    @Test
    public void testInterruption() {
        try {
            System.out.println(Thread.currentThread() + "Try thread");
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println(Thread.currentThread() + "Catch thread");
            throw e;
        } finally {
            System.out.println(Thread.currentThread() + "FinallyTest thread");
        }
    }

    @Test
    @Ignore("will block maven running")
    public void testJVMExit() {
        try {
            System.out.println(Thread.currentThread() + "Try thread");
            System.exit(0);
        } catch (Exception e) {
            System.out.println(Thread.currentThread() + "Catch thread");
            throw e;
        } finally {
            System.out.println(Thread.currentThread() + "FinallyTest thread");
        }
    }
}
