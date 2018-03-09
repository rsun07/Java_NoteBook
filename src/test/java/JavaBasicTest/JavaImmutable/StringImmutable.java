package java.JavaBasicTest.JavaImmutable;

import org.junit.Test;

public class StringImmutable {

    @Test
    public void testStringConstructor() {
        String s = "testString";

        // return false
        // the string constructor creates a hard copy
        String copyS = new String(s);
        System.out.println(s==copyS);

        // return true
        String s0 = "testString";
        System.out.println(s==s0);


        // return true
        System.out.println(s=="testString");

        // return true
        String s2 = s;
        System.out.println(s==s2);
    }

    @Test
    public void testReplace() {
        String s = "test.String";
        // String is immutable, the replace function won't modify the old string
        String s2 = s.replace('.','-');
        System.out.println(s + "  " + s2);
    }
}
