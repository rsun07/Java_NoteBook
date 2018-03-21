package junit.junit4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BasicTest.class, ParameterizedTest.class})
public class TestSuiteDemo {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("\n\nRunning Test Suite Demo\n");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("\n\nFinishing Test Suite Demo\n");
    }
}
