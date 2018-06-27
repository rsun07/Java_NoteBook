package pers.xiaoming.notebook.concurrent.thread.future;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

@Ignore("demo test")
public class FutureTest {

    /*
        Start task and wait
        // wait 2s
        Result is : 100
     */
    @Test
    public void testFutureUseThread() throws Exception {
        CallableTask task = new CallableTask();

        // FutureTask implements RunnableFuture which extends both Runnable and Future
        FutureTask<Integer> future = new FutureTask<>(task);

        // this cannot start the thread
        // task.call();

        new Thread(future).start();

        // this is a blocking method
        int res = future.get();

        System.out.println("Result is : " + res);

        int resCopy = future.get();
        System.out.println("Result Copy is : " + resCopy);
    }


    // following use thread pool to test future
    private static ExecutorService executor;
    private static CallableTask task;

    @BeforeClass
    public static void setup() {
        executor = Executors.newFixedThreadPool(10);
        task = new CallableTask();
    }

    /*
        Start task and wait
        // wait 2s
        100
    */
    @Test
    public void submitCallable() throws Exception {
        Future<Integer> future = executor.submit(task);

        System.out.println(future.get());
    }

    /*
        Start task and wait
        // wait 2s
        null
    */
    @Test
    public void submitRunnable() throws Exception {

        Runnable runnable = () -> {
            try {
                task.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Future<?> future = executor.submit(runnable);

        System.out.println(future.get());
    }

    /*
        Start task and wait
        // wait 2s
        null
        100
    */
    @Test
    public void submitFutureTask() throws Exception {

        FutureTask<?> futureTask = new FutureTask<>(task);

        Future<?> future = executor.submit(futureTask);

        System.out.println(future.get());
        System.out.println(futureTask.get());
    }
}
