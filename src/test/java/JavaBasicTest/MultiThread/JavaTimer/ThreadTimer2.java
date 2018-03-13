package JavaBasicTest.MultiThread.JavaTimer;


import java.util.Date;

public class ThreadTimer2 extends Thread {
    @Override
    public void run() {
        System.out.println("Run task on: " + new Date(System.currentTimeMillis()));
    }

    public static void main(String args[]) throws InterruptedException {
        ThreadTimer2 t1 = new ThreadTimer2();
        while(true) {
            t1.run();
            t1.sleep(5*1000);
        }
    }
}
