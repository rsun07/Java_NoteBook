package junit.junit4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(TestSuiteDemo.class)
public class TestSuiteDecorator {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("\n\nRunning Test Suite Decorator\n");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("\n\nFinishing Test Suite Decorator\n");
    }
}
