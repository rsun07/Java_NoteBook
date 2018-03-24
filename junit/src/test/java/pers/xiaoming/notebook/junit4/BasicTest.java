package pers.xiaoming.notebook.junit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BasicTest {

    // Before Class must be static because it will run before the class load
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class will run only once before all tests");
    }

    @Before
    public void setUp() {
        System.out.println("\n--Set up will run before every single test");
    }

    @After
    public void tearDown() {
        System.out.println("--Tear Down will run after every single test\n");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class will run only once after all test\n");
    }


    @Test
    public void testBasic() {
        System.out.println("----Run basic assert!");

        int actual = 3 - 2;
        int expect = 1;
        Assert.assertEquals(expect, actual);
    }

    @Test(expected = ArithmeticException.class)
    public void testException() {
        System.out.println("----Run exception test!");

        int result = 1/0;
    }

    @Test(timeout = 100)
    public void testTimeout() {
        System.out.println("----Run timeout test!");
    }

    @Ignore("Ignore for testing ignore annotation\n")
    @Test
    public void testIgnore() {
        System.out.println("---- Run ignore test!");
    }
}
