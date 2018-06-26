package pers.xiaoming.notebook.concurrent.thread.future;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MultiThreadFutureTest {

    private static ExecutorService executor;
    private static MultiThreadCallableTask task;

    @BeforeClass
    public static void setup() {
        executor = Executors.newFixedThreadPool(10);
        task = new MultiThreadCallableTask();
    }

    @Test
    public void testMultiThreadTask() throws Exception {
        for (int i = 0; i < 10; i++) {
            FutureTask<?> futureTask = new FutureTask<>(task);
            executor.submit(futureTask);
            System.out.println("Main method : " + futureTask.get());
        }
    }
}
