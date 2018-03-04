package java.JavaBasicTest.LambdaExpression;

import org.junit.Test;

public class threadTest {

    @Test
    public void testThreads() {
        simplestThread();
        anonymousClassThread();
        lambdaThread();
    }

    private void simplestThread() {

        // If you don't understand the "old way" approach, see here
        // the traditional implementation for anonymous class
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("The Traditional way of new class implements Runnable");
            }
        }
        new Thread(new MyRunnable())
                .start();
    }

    private void anonymousClassThread() {
        // old way, anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
    }


    private void lambdaThread() {
        // Lamuda approach
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") )
            .start();
    }
}
