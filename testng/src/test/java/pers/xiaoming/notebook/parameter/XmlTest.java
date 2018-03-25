package pers.xiaoming.notebook.parameter;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class XmlTest {

    @Parameters({"expect", "actual", "expect-int", "actual-int"})
    @Test
    public void test(String expect, String actual, Integer expectInt, Integer actualInt) {
        System.out.printf(
                "Expect is %s, \nActual is %s.\n"
                + "Expect int is %d, \nActual int is %d.\n",
                expect,
                actual,
                expectInt,
                actualInt
        );
        Assert.assertEquals(expect, actual);
        Assert.assertEquals(expectInt, actualInt);
    }

    @Test
    @Parameters({"expect", "actual", "expect-int", "actual-int"})
    public void testReuseParam(String expect, String actual, Integer expectInt, Integer actualInt) {
        System.out.printf(
                "Expect is %s, \nActual is %s.\n"
                + "Expect int is %d, \nActual int is %d.\n",
                expect,
                actual,
                expectInt,
                actualInt
        );
        Assert.assertEquals(expect, actual);
        Assert.assertNotEquals(expectInt, actualInt);
    }
}
