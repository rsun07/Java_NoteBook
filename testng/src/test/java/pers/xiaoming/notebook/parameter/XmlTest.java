package pers.xiaoming.notebook.parameter;

import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class XmlTest {

    @Parameters({"expect", "actual"})
    @Test
    public void test1(String expect, String actual) {
        System.out.printf(
                "Expect is %s, \nActual is %s.\n",
                expect,
                actual
        );
        Assert.assertEquals(expect, actual);
    }
}
