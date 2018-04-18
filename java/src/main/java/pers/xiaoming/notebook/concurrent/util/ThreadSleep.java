package pers.xiaoming.notebook.concurrent.util;

public class ThreadSleep {
    // default sleep 1s
    public static void sleep() {
        sleep(1000);
    }

    public static void sleep500() {
        sleep(500);
    }

    public static void sleep(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
