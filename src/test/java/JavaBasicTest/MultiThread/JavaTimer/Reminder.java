package JavaBasicTest.MultiThread.JavaTimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {

    Timer timer;

    public Reminder(int seconds) {
        // this will run on backend because the true means isDaemon
//        timer = new Timer(true);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Run task on: " + new Date(System.currentTimeMillis()));
            }
        }, seconds * 3000, seconds * 1000);
    }

    public static void main(String args[]) {
        new Reminder(1);
    }
}
