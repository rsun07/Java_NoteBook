package pers.xiaoming.notebook.concurrent.thread.threadlocal;

import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalValueTest {

    /*
        List in Thread Thread[Backend_Thread,5,main] is : [1, 2, 3, 3]
        Main Local List in Thread Thread[Backend_Thread,5,main] is : null
        Local Thread List in Thread Thread[Backend_Thread,5,main] is : [1, 2, 3, 3]

        List in Thread Thread[main,5,main] is : [1, 2, 3, 3]
        ThreadLocal List in Thread Thread[main,5,main] is : [1, 2, 3, 3]
     */
    @Test
    public void test_thread_local_for_list_reference() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        ThreadLocal<List<Integer>> mainLocalList = new ThreadLocal<>();
        mainLocalList.set(list);

        new Thread(() -> {
            ThreadLocal<List<Integer>> localThreadList = new ThreadLocal<>();
            localThreadList.set(list);

            list.add(3);
            localThreadList.get().add(3);

            Assert.assertTrue(list == localThreadList.get());

            System.out.printf("List in Thread %s is : %s\n", Thread.currentThread(), list.toString());
            System.out.printf("Main Local List in Thread %s is : %s\n", Thread.currentThread(), mainLocalList.get());
            System.out.printf("Local Thread List in Thread %s is : %s\n", Thread.currentThread(), localThreadList.get());
        }, "Backend_Thread").start();

        Assert.assertTrue(list == mainLocalList.get());

        ThreadSleep.sleep(100);
        System.out.println( );
        System.out.printf("List in Thread %s is : %s\n", Thread.currentThread(), list.toString());
        System.out.printf("ThreadLocal List in Thread %s is : %s\n", Thread.currentThread(), mainLocalList.get());
    }

    /*
        List in Thread Thread[Backend_Thread,5,main] is : abcd
        Main Local List in Thread Thread[Backend_Thread,5,main] is : null
        Local Thread List in Thread Thread[Backend_Thread,5,main] is : abcd

        List in Thread Thread[main,5,main] is : abcd
        ThreadLocal List in Thread Thread[main,5,main] is : abcd
     */
    @Test
    public void test_thread_local_for_string_builder() {
        StringBuilder sb = new StringBuilder("a");
        sb.append('b');
        ThreadLocal<StringBuilder> mainLocalSb = new ThreadLocal<>();
        mainLocalSb.set(sb);

        new Thread(() -> {
            ThreadLocal<StringBuilder> localThreadSb = new ThreadLocal<>();
            localThreadSb.set(sb);

            sb.append('c');
            localThreadSb.get().append('d');

            Assert.assertTrue(sb == localThreadSb.get());

            System.out.printf("List in Thread %s is : %s\n", Thread.currentThread(), sb.toString());
            System.out.printf("Main Local List in Thread %s is : %s\n", Thread.currentThread(), mainLocalSb.get());
            System.out.printf("Local Thread List in Thread %s is : %s\n", Thread.currentThread(), localThreadSb.get());
        }, "Backend_Thread").start();

        Assert.assertTrue(sb == mainLocalSb.get());

        ThreadSleep.sleep(100);
        System.out.println( );
        System.out.printf("List in Thread %s is : %s\n", Thread.currentThread(), sb.toString());
        System.out.printf("ThreadLocal List in Thread %s is : %s\n", Thread.currentThread(), mainLocalSb.get());
    }


    /*
        List in Thread Thread[Backend_Thread,5,main] is : a
        Main Local List in Thread Thread[Backend_Thread,5,main] is : null
        Local Thread List in Thread Thread[Backend_Thread,5,main] is : ab

        List in Thread Thread[main,5,main] is : a
        ThreadLocal List in Thread Thread[main,5,main] is : a
     */
    @Test
    public void test_thread_local_for_immutable_class_string() {
        String str = "a";
        ThreadLocal<String> localStr = new ThreadLocal<>();
        localStr.set(str);

        new Thread(() -> {
            ThreadLocal<String> localThreadStr = new ThreadLocal<>();
            localThreadStr.set(str);

            // cannot change str value because in lambda it should be final or effectively final
            // str = "b";
            localThreadStr.set(localThreadStr.get() + "b");

            Assert.assertTrue(str != localThreadStr.get());

            System.out.printf("String in Thread %s is : %s\n", Thread.currentThread(), str);
            System.out.printf("Main Local String in Thread %s is : %s\n", Thread.currentThread(), localStr.get());
            System.out.printf("Local Thread String in Thread %s is : %s\n", Thread.currentThread(), localThreadStr.get());
        }, "Backend_Thread").start();

        Assert.assertTrue(str == localStr.get());

        ThreadSleep.sleep(100);
        System.out.println( );
        System.out.printf("String in Thread %s is : %s\n", Thread.currentThread(), str);
        System.out.printf("ThreadLocal String in Thread %s is : %s\n", Thread.currentThread(), localStr.get());
    }
}
