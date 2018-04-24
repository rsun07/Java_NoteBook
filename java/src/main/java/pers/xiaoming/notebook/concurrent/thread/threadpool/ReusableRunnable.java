package pers.xiaoming.notebook.concurrent.thread.threadpool;

class ReusableRunnable implements Runnable {
    private Runnable task;
    private boolean isRunning;

    ReusableRunnable(Runnable runnable) {
        this.task = runnable;
        if (runnable != null) {
            this.isRunning = true;
        }
    }

    public void setTask(Runnable runnable) {
        this.task = runnable;
        if (runnable != null) {
            this.isRunning = true;
        }
    }

    @Override
    public void run() {
        while(true) {
            if (isRunning) {
                task.run();
                isRunning = false;
                task = null;
            }
        }
    }
}
