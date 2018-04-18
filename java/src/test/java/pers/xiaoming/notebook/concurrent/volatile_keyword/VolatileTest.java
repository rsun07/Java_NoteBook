package pers.xiaoming.notebook.concurrent.volatile_keyword;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("demo tests")
public class VolatileTest {
    @Test
    public void testFailVisibility() throws InterruptedException {
        FailVisibility thread = new FailVisibility();
        thread.start();

        new Thread(() ->
            {
                thread.setStoped(true);
                System.out.println("Already set stop to true");
            }
        ).start();

        thread.join();
    }

    @Test
    public void testAchieveVisibility() throws InterruptedException {
        AchieveVisibility thread = new AchieveVisibility();
        thread.start();

        new Thread(() ->
            {
                thread.setStoped(true);
                System.out.println("Already set stop to true");
            }
        ).start();

        thread.join();
    }
}
