package pers.xiaoming.notebook.lang.enum_;

import org.junit.Assert;
import org.junit.Test;

public class EnumStaticTest {

    @Test
    public void test() {
        Assert.assertTrue(EnumWithStatic.contains("one"));
        Assert.assertFalse(EnumWithStatic.contains("five"));
    }
}
