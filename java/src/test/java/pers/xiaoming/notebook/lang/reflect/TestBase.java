package pers.xiaoming.notebook.lang.reflect;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Field;

@Ignore("Demo test")
public class TestBase {
    static final String TEST_CLASS = "pers.xiaoming.notebook.reflection.Person";

    static Class testClass;

    @BeforeClass
    public static void setup() throws ClassNotFoundException {
        testClass = Class.forName(TEST_CLASS);
    }

    @Test
    @Ignore
    public void testOtherFunctions() throws Exception {
        System.out.println("\n");

        System.out.println("Package is :" + testClass.getPackage());
        System.out.println("Name is :" + testClass.getName());
        System.out.println("Simple Name is :" + testClass.getSimpleName());
        System.out.println("Type Name is :" + testClass.getTypeName());

        System.out.println("Superclass is :" + testClass.getSuperclass());
        System.out.println("Modifiers is :" + testClass.getModifiers());

        System.out.println("\nDeclared Fields as following: ");
        for (Field field : testClass.getDeclaredFields())
            System.out.println("Method is :" +  field);

    }
}
