package Junit.Junit3;

import junit.framework.TestCase;
import org.junit.Assert;


public class BasicTest extends TestCase {
    @Override
    public void setUp() {
        System.out.println("\nSet up will run before every single test");
    }

    @Override
    public void tearDown() {
        System.out.println("Tear Down will run after every single test\n");
    }

    /**
     *
     * The name of the test must have "test-" prefix
     *
     * Function must be public, with void return type.
     *
     */

    public void testBasicAssert() {
        int actual = 3 - 2;
        int expect = 1;
        Assert.assertEquals(expect, actual);
    }


    public void testDoubleAssert() {
        double actual = 12.3 - 2.79;
        double expect = 9.51;
        double delta = 0.000001;
        Assert.assertEquals(actual, expect, delta);
    }


    public void testException() {
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
