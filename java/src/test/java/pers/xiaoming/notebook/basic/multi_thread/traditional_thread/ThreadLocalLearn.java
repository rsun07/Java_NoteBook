package pers.xiaoming.notebook.basic.multi_thread.traditional_thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadLocalLearn {
    public static void main(String[] args) {
        new ThreadLocalLearn().getFail();
//        new ThreadLocalLearn().getSuccess();

    }

    static class A {
        void getSame() {
            System.out.println(
                "A from thread " + Thread.currentThread().getName() + " get data : " + data);
        }

        void getDiff() {
            int diffData = threadMap.get(Thread.currentThread().getName());
            System.out.println(
                "A from thread " + Thread.currentThread().getName() + " get data : " + diffData);
        }
    }

    static class B {
        void getSame() {
            System.out.println(
                "B from thread " + Thread.currentThread().getName() + " get data : " + data);
        }

        void getDiff() {
            int diffData = threadMap.get(Thread.currentThread().getName());
            System.out.println(
                "B from thread " + Thread.currentThread().getName() + " get data : " + diffData);
        }
    }


    private static Map<String, Integer> threadMap = new HashMap<>();
    void getSuccess() {
        for (int i = 0; i < 2; i++) {
            int randomData = new Random().nextInt();
            new Thread( () -> {
                threadMap.put(Thread.currentThread().getName(), randomData);
                System.out.println(
                    Thread.currentThread().getName() + " put data : " + randomData);
                new A().getDiff();
                new B().getDiff();
            }).start();
        }
    }


    private static int data;
    void getFail() {
        for (int i = 0; i < 2; i++) {
            int randomData = new Random().nextInt();
            new Thread( () -> {
                data = randomData;
                System.out.println(
                    Thread.currentThread().getName() + " put data : " + data);
                new A().getSame();
                new B().getSame();

            }).start();
            /*
            The reason why get fail is because when thread-0 try to get A and B,
            thread-1 already update the value.
             */

//            try {
//                TimeUnit.MILLISECONDS.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
