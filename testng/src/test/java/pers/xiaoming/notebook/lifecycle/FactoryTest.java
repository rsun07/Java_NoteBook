package pers.xiaoming.notebook.lifecycle;

import org.testng.annotations.Factory;

public class FactoryTest {
    @Factory
    public Object[] factoryMethod() {
        System.out.println("\n\nFactory Method will run even before TestNG running!\n\n");
        return new FactoryTest[] {
                new FactoryTest(),
        };
    }
}
