package basic.lang.system_and_runtime;

import org.junit.Test;

public class SystemTest {
    @Test
    public void test() {
        MyStringWithFinalizer myStr = new MyStringWithFinalizer("MyString");
        for (int i = 0; i < 8; i++) {
            myStr.append(i);
        }

        // System.gc() is calling Runtime.getRuntime().gc();
         System.gc();
    }
}
