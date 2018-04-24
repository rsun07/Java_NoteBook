package pers.xiaoming.notebook.concurrent.thread.threadlocal;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Ignore("demo tests")
public class MultiThreadTest {

    /*
        Result in Thread[Thread-0,5,main] is : 100
        Demo name is : Thread-0
        Result in Thread[Thread-1,5,main] is : 200
        Demo name is : Thread-1
        Result in Main Thread is : 200
        Name in Main Thread is : Thread-1
     */
    @Test
    public void testNoThreadLocal() {
        ThreadLocalDemo testClass = new NoThreadLocalDemo();
        test(testClass);

        System.out.println("Result in Main Thread is : " + testClass.getRes());
        System.out.println("Name in Main Thread is : " + testClass.getName());
    }

    /*
        Result in Thread[Thread-0,5,main] is : 100
        Demo name is : Thread-0
        Result in Thread[Thread-1,5,main] is : 100
        Demo name is : Thread-1
        Result in Main Thread is : 0
        Name in Main Thread is :
     */
    @Test
    public void testUseThreadLocal() {
        ThreadLocalDemo testClass = new UseThreadLocalDemo();
        test(testClass);

        System.out.println("Result in Main Thread is : " + testClass.getRes());
        System.out.println("Name in Main Thread is : " + testClass.getName());
    }

    private CountDownLatch countDownLatch = new CountDownLatch(2);

    private void test(ThreadLocalDemo testClass) {

        new Thread(() -> this.run(testClass)).start();
        new Thread(() -> this.run(testClass)).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void run(ThreadLocalDemo testClass) {

        for (int i = 0; i < 100; i++) {
            testClass.add();
        }

        System.out.println("Result in " + Thread.currentThread() + " is : " + testClass.getRes());

        testClass.setName(Thread.currentThread().getName());

        System.out.println("Demo name is : " + testClass.getName());

        countDownLatch.countDown();
    }
}
