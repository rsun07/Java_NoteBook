package pers.xiaoming.notebook.concurrent.guava;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import javax.annotation.Nullable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@Ignore("Demo test")
public class ListenableFutureTest {
    private static ListeningExecutorService service;

    @BeforeClass
    public static void setup() {
        service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
    }

    /*
        Start task and wait
        // wait 2s
        Main, get future value : 100
     */
    @Test
    public void testGetListener() {
        ListenableFuture<?> listenableFuture = service.submit(new CallableTask());
        listenableFuture.addListener(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Main, get future value : " + listenableFuture.get());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                }, service);

        ThreadSleep.sleepSecs(3);
    }

    /*
        Start task and wait
        // wait 2s
        Main, get future value : 100
    */
    @Test
    public void testAddCallback() {

        for (int i = 0; i < 5; i++) {
            ListenableFuture<Integer> listenableFuture = service.submit(new HalfFailureCallableTask());

            Futures.addCallback(
                    listenableFuture,

                    new FutureCallback<Integer>() {
                        @Override
                        public void onFailure(Throwable throwable) {
                            System.out.println("Main, get future value Failed!");
                        }
                        @Override
                        public void onSuccess(@Nullable Integer result) {
                            System.out.println("Main, get future value : " + result);
                        }
                    },

                    service);
        }

        ThreadSleep.sleepSecs(3);
    }

}
