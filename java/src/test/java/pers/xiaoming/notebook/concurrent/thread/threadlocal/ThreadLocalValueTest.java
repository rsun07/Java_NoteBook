package pers.xiaoming.notebook.concurrent.thread.threadlocal;

import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalValueTest {

    @Test
    public void test_thread_local_for_list_reference() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        ThreadLocal<List<Integer>> localList = new ThreadLocal<>();
        localList.set(list);

        new Thread(() -> {
            ThreadLocal<List<Integer>> localThreadList = new ThreadLocal<>();
            localThreadList.set(list);

            list.add(3);
            localThreadList.get().add(3);

            Assert.assertTrue(list == localThreadList.get());

            System.out.printf("List in Thread %s is : %s\n", Thread.currentThread(), list.toString());
            System.out.printf("Main Local List in Thread %s is : %s\n", Thread.currentThread(), localList.get());
            System.out.printf("Local Thread List in Thread %s is : %s\n", Thread.currentThread(), localThreadList.get());
        }, "Backend_Thread").start();

        Assert.assertTrue(list == localList.get());

        ThreadSleep.sleep(100);
        System.out.println( );
        System.out.printf("List in Thread %s is : %s\n", Thread.currentThread(), list.toString());
        System.out.printf("ThreadLocal List in Thread %s is : %s\n", Thread.currentThread(), localList.get());
    }

    @Test
    public void test_thread_local_for_string_builder_non_reference() {
        StringBuilder sb = new StringBuilder("a");
        sb.append('b');
        ThreadLocal<StringBuilder> localList = new ThreadLocal<>();
        localList.set(sb);

        new Thread(() -> {
            ThreadLocal<StringBuilder> localThreadList = new ThreadLocal<>();
            localThreadList.set(sb);

            sb.append('c');
            localThreadList.get().append('d');

            Assert.assertTrue(sb == localThreadList.get());

            System.out.printf("List in Thread %s is : %s\n", Thread.currentThread(), sb.toString());
            System.out.printf("Main Local List in Thread %s is : %s\n", Thread.currentThread(), localList.get());
            System.out.printf("Local Thread List in Thread %s is : %s\n", Thread.currentThread(), localThreadList.get());
        }, "Backend_Thread").start();

        Assert.assertTrue(sb == localList.get());

        ThreadSleep.sleep(100);
        System.out.println( );
        System.out.printf("List in Thread %s is : %s\n", Thread.currentThread(), sb.toString());
        System.out.printf("ThreadLocal List in Thread %s is : %s\n", Thread.currentThread(), localList.get());
    }
}
