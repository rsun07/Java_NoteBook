package Junit.Junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BasicTest.class, ParameterizedTest.class})
public class TestSuiteDemo {
}
