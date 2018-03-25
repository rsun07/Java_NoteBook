package pers.xiaoming.notebook.parameter;

import org.testng.TestNG;

// run test NG as a Java program
public class FactoryTestRun {
    // Another way to run TestNG
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[] {MyFactory.class});
        testNG.run();
    }
}
