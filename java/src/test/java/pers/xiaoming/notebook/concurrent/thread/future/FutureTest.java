package pers.xiaoming.notebook.concurrent.thread.future;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.FutureTask;

@Ignore("demo test")
public class FutureTest {

    /*
        Start task and wait
        // wait 2s
        Result is : 100
     */
    @Test
    public void testFuture() throws Exception {
        CallableTask task = new CallableTask();
        FutureTask<Integer> future = new FutureTask<>(task);

        // this cannot start the thread
        // task.call();

        new Thread(future).start();

        // this is a blocking method
        int res = future.get();

        System.out.println("Result is : " + res);
    }
}
