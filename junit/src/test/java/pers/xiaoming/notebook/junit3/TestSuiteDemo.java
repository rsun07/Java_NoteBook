package pers.xiaoming.notebook.junit3;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestSuiteDemo extends TestCase {

    public static TestSuite suite() {
        TestSuite testSuite = new TestSuite();

        testSuite.addTestSuite(BasicTest.class);
        testSuite.addTestSuite(ExceptionTest.class);

        return testSuite;
    }
}
