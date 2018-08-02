package pers.xiaoming.notebook.concurrent.thread.future;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
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

    // This test, every task will block the next one.
    // The guava ListenableFutureTest wont!

    /*
        pool-1-thread-1 is running num 0
        // wait 2s
        Main method : pool-1-thread-1 is running num 0
        pool-1-thread-2 is running num 1
        // wait 2s
        Main method : pool-1-thread-2 is running num 1
        pool-1-thread-3 is running num 2
        // wait 2s
        Main method : pool-1-thread-3 is running num 2
        pool-1-thread-4 is running num 3
        // wait 2s
        Main method : pool-1-thread-4 is running num 3
        pool-1-thread-5 is running num 4
        // wait 2s
        Main method : pool-1-thread-5 is running num 4
     */
    @Test
    public void testMultiThreadTask() throws Exception {
        for (int i = 0; i < 5; i++) {
            FutureTask<?> futureTask = new FutureTask<>(task);
            executor.submit(futureTask);
            System.out.println("Main method : " + futureTask.get());
        }
    }

    /*
        This is a non-block implementation:
        But obviously the guava one is more convenient

        pool-1-thread-2 is running num 1
        pool-1-thread-1 is running num 0
        pool-1-thread-3 is running num 2
        pool-1-thread-4 is running num 3
        pool-1-thread-5 is running num 4
        // wait 2s
        Num 0 task result is : pool-1-thread-1 is running num 0
        Num 1 task result is : pool-1-thread-2 is running num 1
        Num 2 task result is : pool-1-thread-3 is running num 2
        Num 3 task result is : pool-1-thread-4 is running num 3
        Num 4 task result is : pool-1-thread-5 is running num 4
     */
    @Test
    public void testMultiThreadTaskWithFutureList() throws Exception {
        Map<Integer, FutureTask<?>> futureTasks = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            FutureTask<?> futureTask = new FutureTask<>(task);
            futureTasks.put(i, futureTask);
            executor.submit(futureTask);
        }

        for (Map.Entry<Integer, FutureTask<?>> entry : futureTasks.entrySet()) {
            System.out.println(String.format("Num %s task result is : %s", entry.getKey(), entry.getValue().get()));
        }
    }
}
