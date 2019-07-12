package pers.xiaoming.notebook.concurrent.volatile_keyword;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("demo tests")
public class VolatileTest {
    @Test
    public void testNoVisibility() throws InterruptedException {
        NoVolatileThread thread = new NoVolatileThread();
        thread.start();

        new Thread(() -> {
                thread.setKeepRunning(false);
                System.out.println("Already set keepRunning to false");
            }).start();

        thread.join();
    }

    @Test
    public void testAchieveVisibility() throws InterruptedException {
        VolatileThread thread = new VolatileThread();
        thread.start();

        new Thread(() -> {
                thread.setKeepRunning(false);
                System.out.println("Already set keepRunning to false");
            }).start();

        thread.join();
    }
}
