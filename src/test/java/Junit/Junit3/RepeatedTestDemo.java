package Junit.Junit3;

import junit.extensions.RepeatedTest;
import junit.framework.TestCase;

public class RepeatedTestDemo extends TestCase {

    // run the BasicTest for 3 times
    public void test() {
        new RepeatedTest(new BasicTest(), 7);
    }
}
