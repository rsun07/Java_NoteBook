package pers.xiaoming.notebook.multi_thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BackendThread {
    private final int corePoolSize = 1;
    private final int maximumPoolSize = 1;
    private final int keepAliveTime = 10;
    private final TimeUnit unit = TimeUnit.MILLISECONDS;
    private final BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(1);
    private ThreadPoolExecutor threadPoolExecutor;

    public BackendThread() {
        threadPoolExecutor = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSize,
            keepAliveTime,
            unit,
            workQueue,
            new ThreadPoolExecutor.DiscardPolicy()
        );
    }

    public static void main(String[] args) {
        BackendThread backendThread = new BackendThread();
        backendThread.runItOne();
        backendThread.runItTwo();
        backendThread.runItThree();

    }

    private void runItOne() {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                runIt("Run it One");
            }
        });
//        threadPoolExecutor.shutdown();
    }

    private void runItTwo() {
        threadPoolExecutor.execute(() -> {
            runIt("Run it Two");
        });
    }

    private void runItThree() {
        threadPoolExecutor.execute(() -> {
            runIt("Run it Three");
        });
    }

    private class RunItThree implements Runnable {
        @Override
        public void run() {
            runIt("Run it Three");
        }
    }

    private int i = 0;
    private void runIt(String functionName) {
        while (i < 10) {
            System.out.println(functionName + " : " + i++);
//            System.out.println("CorePoolSize = " + threadPoolExecutor.getCorePoolSize());
//            System.out.println("Queue = " + threadPoolExecutor.getQueue());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

