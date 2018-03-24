package pers.xiaoming.notebook.junit3;

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
        System.out.println("Run basic assert!");

        int actual = 3 - 2;
        int expect = 1;
        Assert.assertEquals(expect, actual);
    }


    public void testDoubleAssert() {
        System.out.println("Run double assert!");

        double actual = 12.3 - 2.79;
        double expect = 9.51;
        double delta = 0.000001;
        Assert.assertEquals(actual, expect, delta);
    }
}
