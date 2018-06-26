package pers.xiaoming.notebook.concurrent.thread.future;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MultiThreadFutureTest {

    private static ExecutorService executor;
    private static CallableTask mySingleTask;

    @BeforeClass
    public static void setup() {
        executor = Executors.newFixedThreadPool(10);
        mySingleTask = new CallableTask();
    }

    @Test
    public void submitCallable() throws Exception {

        Future<Integer> future = executor.submit(mySingleTask);

        System.out.println(future.get());
    }

    @Test
    public void submitRunnable() throws Exception {

        Runnable runnable = () -> {
            try {
                mySingleTask.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Future<?> future = executor.submit(runnable);

        System.out.println(future.get());
    }

    @Test
    public void submitFutureTask() throws Exception {

        FutureTask<?> futureTask = new FutureTask<>(mySingleTask);

        Future<?> future = executor.submit(futureTask);

        System.out.println(future.get());
        System.out.println(futureTask.get());
    }
}
