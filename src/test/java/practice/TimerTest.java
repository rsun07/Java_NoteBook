package practice;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public void TimerTest() {
        Timer timer = new Timer();
        timer.schedule(new TimeTask(), 5 * 1000);
    }


    class TimeTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Run task on: " + new Date(System.currentTimeMillis()));
        }
    }
}
