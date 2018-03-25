package pers.xiaoming.notebook.parameter;

import org.testng.annotations.Factory;

// run the test from here or from xml,
// not the FactoryTest class
public class MyFactory {
    @Factory
    public Object[] factoryMethod() {
        return new FactoryTest[] {
            new FactoryTest("1", System.currentTimeMillis()),
            new FactoryTest("2", System.currentTimeMillis()),
        };
    }
}
