package java.JavaBasicTest.MultiThread.JavaTimer;

import java.util.Date;

public class ThreadTimer implements Runnable {

    @Override
    public void run() {
        System.out.println("Run task on: " + new Date(System.currentTimeMillis()));
    }

    public static void main(String args[]) throws InterruptedException {
        ThreadTimer tt1 = new ThreadTimer();
        Thread t1 = new Thread(tt1);
        while(true) {
            t1.start();
            t1.sleep(5*1000);
        }
    }

    private void ThreadTimerRunner(){

    }
}
