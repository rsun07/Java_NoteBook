package pers.xiaoming.notebook.concurrent.traditional_thread;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class TraditionalThread {

    @Test
    public void testThread() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                loop("thread");
            }
        };
        thread.start();
    }

    @Test
    public void testRunnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                loop("runnable");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Test
    public void testLambda() {
        Runnable runnable = ()-> loop("runnable Lambda");
        new Thread(runnable).start();
    }

    private void loop(String name) {
        for(int i = 0; i < 20; i++) {
            System.out.println(name + "   " + Thread.currentThread().getName());
        }
    }

    private void sleep(int secs) {
        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testCallable() throws ExecutionException, InterruptedException {
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return (new Random()).nextInt(100);
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(task);

        // This line will keep waiting until interrupt because before task run,
        // the futureTask.get() has nothing but wait
//        System.out.println(futureTask.get());

        futureTask.run();

        System.out.println(futureTask.get());
    }
}
