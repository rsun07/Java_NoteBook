package pers.xiaoming.notebook.lang.reflect;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.reflection.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@Ignore("demo test")
public class MethodTest extends TestBase {
    private static Person person;

    @BeforeClass
    public static void setup() throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        testClass = Class.forName(TEST_CLASS);
        person = (Person) testClass.newInstance();
    }

    @After
    public void after() {
        System.out.println();
    }

    @Test
    public void testGetAllMethods() {
        System.out.println("\nPublic Methods as following: ");
        for (Method method : testClass.getMethods()) {
            System.out.println("Method is :" + method);
        }

        System.out.println("\nDeclared Methods as following: ");
        for (Method method : testClass.getDeclaredMethods()) {
            System.out.println("Method is :" + method);
        }
    }

    @Test
    public void testNoArgMethod() throws InvocationTargetException,
            IllegalAccessException, NoSuchMethodException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getMethod("noArgPublicMethod", null);
        method.invoke(person, null);
    }

    @Test
    public void testOneArgMethod() throws InvocationTargetException,
            IllegalAccessException, NoSuchMethodException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getMethod("oneArgPublicMethod", String.class);
        method.invoke(person, "Method with one String method called");
    }

    @Test
    public void testTwoArgsMethod() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getDeclaredMethod("twoArgsPublicMethod", String.class, int[].class);
        Class[] classes = (Class[]) method.invoke(
                person,
                "Private Function with String and int[] parameters called",
                new int[]{1, 2, 3}
        );
        System.out.println("Classes as follows: " + Arrays.toString(classes));
    }

    @Test
    public void testStaticMethod() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getMethod("staticPublicMethod", int.class);
        // static method doesn't need the instance/object of the class to invoke
        method.invoke(null, 3);
        System.out.println("\n");
    }

    @Test
    public void testPrivateMethod() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getDeclaredMethod("privateMethod", String.class, int[].class);
        method.setAccessible(true);
        System.out.println("Classes as follows: ");
    }
}
