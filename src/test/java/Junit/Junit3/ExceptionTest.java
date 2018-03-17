package Junit.Junit3;

import junit.framework.TestCase;
import org.junit.Assert;

public class ExceptionTest extends TestCase {

    public void testException() {
        System.out.println("Run exception assert!");

        int result = 0;
        Throwable t = null;

        try {
            result = 1/0;

            // Because Developer already know, the test cannot reach this line
            // If it reaches, the test fails.
            Assert.fail();
        } catch(Exception e) {
            t = e;
        }

        Assert.assertEquals(ArithmeticException.class, t.getClass());
        Assert.assertEquals("/ by zero", t.getMessage());
    }
}
