package pers.xiaoming.notebook.concurrent.thread.threadpool;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// more for understanding the mechanism rather than run it
class MyThreadPoolExecutor implements ExecutorService {
    private static final Lock LOCK = new ReentrantLock();
    private static final Condition condition = LOCK.newCondition();

    private static final int DEFAULT_QUEUE_SIZE = 10;

    private final int corePoolSize;
    private final int maxPoolSize;

    private List<Worker> workers;
    private BlockingQueue<Runnable> tasks;

    MyThreadPoolExecutor(int corePoolSize) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = 2 * corePoolSize;
        this.workers = new LinkedList<>();
        this.tasks = new ArrayBlockingQueue<>(DEFAULT_QUEUE_SIZE);
        initWorkers();
    }

    MyThreadPoolExecutor(int corePoolSize, BlockingQueue<Runnable> queue) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = 2 * corePoolSize;
        this.workers = new LinkedList<>();
        this.tasks = queue;
        initWorkers();
    }

    private void initWorkers() {
        for (int i = 0; i < corePoolSize; i++) {
            LOCK.lock();
            try {
                Worker worker = new Worker();
                workers.add(worker);

                String threadName = Thread.currentThread().getName() + ", Thread - " + i;
                new Thread(worker, threadName).start();
            } finally {
                LOCK.unlock();
            }
        }
    }

    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new IllegalArgumentException();
        }

        LOCK.lock();
        try {
            tasks.put(command);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    private final class Worker implements Runnable {
        private boolean isRunning;

        Worker() {
            this.isRunning = true;
        }

        @Override
        public void run() {
            while(isRunning) {
                LOCK.lock();
                try {
                    if (tasks.isEmpty()) {
                        condition.await();
                    }

                    Runnable task = tasks.take();
                    if (task != null) {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }
            }
        }

        void shutdown() {
            this.isRunning = false;
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    //  TODO: implements following methods later
    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
