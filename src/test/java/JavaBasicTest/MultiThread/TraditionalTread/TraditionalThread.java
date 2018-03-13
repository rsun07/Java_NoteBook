package JavaBasicTest.MultiThread.TraditionalTread;

import java.util.concurrent.TimeUnit;

public class TraditionalThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                loop("thread 1");
            }
        };
        thread1.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                loop("runnable");
            }
        };
        Thread thread2 = new Thread(runnable);
        thread2.start();

        Runnable runnable2 = ()-> loop("runnable 2");
        Thread thread3 = new Thread(runnable2);
        thread3.start();


        new Thread(runnable) {
            @Override
            public void run() {
                loop("thread 4");
            }
        }.start();
    }

    public static void loop(String name) {
        while(true) {
            try {
//                        Thread.sleep(1000);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "   " + Thread.currentThread().getName());
        }
    }
}
