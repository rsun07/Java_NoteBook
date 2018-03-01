package JavaTest.JavaBasicTest.String;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {
    @Test
    public void testNewReference() {
        String str = "String";
        String strRef = str;

        Assert.assertEquals(strRef, str);
        Assert.assertEquals(strRef.hashCode(), str.hashCode());
        Assert.assertTrue(str == strRef);
    }

    // Constructor create a new Object / Instance
    @Test
    public void testConstructor() {
        String str = "String";
        String strRef = new String("String");

        Assert.assertEquals(strRef, str);
        Assert.assertEquals(strRef.hashCode(), str.hashCode());
        Assert.assertFalse(str == strRef);
    }


    @Test
    public void testStringBuilder() {
        String str = "String";
        StringBuilder sb = new StringBuilder(str);
        String strSb = sb.toString();

        Assert.assertEquals(strSb, str);
        Assert.assertEquals(strSb.hashCode(), str.hashCode());
        Assert.assertFalse(str == strSb);
    }


    @Test
    public void testChangingReference() {
        String str = "String";
        String strRef = str;
        String newStr = "New String";

        Assert.assertEquals(strRef, str);
        Assert.assertTrue(str == strRef);

        Assert.assertNotEquals(str, newStr);

        str = newStr;

        Assert.assertNotEquals(strRef, str);
        Assert.assertFalse(str == strRef);

        Assert.assertEquals(str, newStr);
        Assert.assertTrue(str == newStr);
    }
}
