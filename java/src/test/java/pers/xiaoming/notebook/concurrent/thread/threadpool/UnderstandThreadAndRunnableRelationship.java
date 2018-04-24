package pers.xiaoming.notebook.concurrent.thread.threadpool;

import org.junit.Test;

/*
    Thread.run() will run the implementation of the functional interface Runnable's run() method
    within current thread. It won't create a new background thread.

    Thread.start() will use Java native method to create a new background thread to run
    the implementation of run() method.

    ThreadPool use this, use a Work class which implements Runnable, also has a Thread reference.
    So the thread could run
 */

public class UnderstandThreadAndRunnableRelationship {


    /*
        Thread[main,5,main] is executing
        Thread[Thread_Start,5,main] is executing
     */
    @Test
    public void testStartAndRunDiff() {
        new Thread(this::myRunnable, "Thread_Start").start();
        new Thread(this::myRunnable, "Thread_Run").run();
    }

    private void myRunnable() {
        System.out.println(Thread.currentThread() + " is executing");
    }

    // failed to change Runnable for MyThread because Runnable is a private attribute
    // within Thread class an there is no setter access
    @Test
    public void testReuseThread() throws InterruptedException {
        MyThread myThread = new MyThread(
                () -> System.out.println("1. Executing my thread with initial runnable")
        );

        myThread.start();

        myThread.setMyRunnable(this::myRunnable);
        myThread.run();

        myThread.setMyRunnable(
                () -> {
                    System.out.println("2. Executing my thread with updated runnable");
                    System.out.println("3. Executing my thread with updated runnable");
                }
        );

        myThread.join();
    }
}