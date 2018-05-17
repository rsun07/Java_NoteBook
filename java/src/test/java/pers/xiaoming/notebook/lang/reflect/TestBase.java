package pers.xiaoming.notebook.lang.reflect;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.lang.reflection.Person;

@Ignore("Demo test")
public class TestBase {
    private static final String TEST_CLASS = "pers.xiaoming.notebook.lang.reflection.Person";

    static Class testClass;
    static Person person;


    @BeforeClass
    public static void setup() throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        testClass = Class.forName(TEST_CLASS);
        person = (Person) testClass.newInstance();
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
    }
}
