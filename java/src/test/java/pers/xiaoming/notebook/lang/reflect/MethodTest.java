package pers.xiaoming.notebook.lang.reflect;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.reflection.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Ignore("demo test")
public class MethodTest extends TestBase {
    private static Person person;

    @BeforeClass
    public static void setupMethodTest() throws IllegalAccessException, InstantiationException {
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
        method.invoke(person, "Public One Arg");
    }

    @Test
    public void testTwoArgsMethod() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getMethod("twoArgsPublicMethod", String.class, int.class);
        method.invoke(person, "Public Two Args, int=", 8);
    }

    @Test
    public void testDefaultAccessMethod() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getDeclaredMethod("defaultAccessMethod", String.class);
        method.setAccessible(true);
        method.invoke(person, "Default One Arg");
    }

    @Test(expected = NoSuchMethodException.class)
    public void testDefaultAccessMethodNoSuchMethod() throws NoSuchMethodException {
        try {
            @SuppressWarnings("unchecked")
            Method method = testClass.getMethod("defaultAccessMethod", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Test(expected = IllegalAccessException.class)
    public void testDefaultAccessMethodIllegalAccess() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getDeclaredMethod("defaultAccessMethod", String.class);
        try {
            method.invoke(person, "Default One Arg");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    public void testProtectedAccessMethod() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getDeclaredMethod("protectedAccessMethod", String.class);
        method.setAccessible(true);
        method.invoke(person, "Protected One Arg");
    }

    @Test(expected = NoSuchMethodException.class)
    public void testProtectedAccessMethodNoSuchMethod() throws NoSuchMethodException {
        try {
            @SuppressWarnings("unchecked")
            Method method = testClass.getMethod("protectedAccessMethod", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Test(expected = IllegalAccessException.class)
    public void testProtectedAccessMethodIllegalAccess() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getDeclaredMethod("protectedAccessMethod", String.class);
        try {
            method.invoke(person, "Protected One Arg");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    public void testPrivateMethod() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getDeclaredMethod("privateMethod", String.class);
        method.setAccessible(true);
        method.invoke(person, "Private One Arg");
    }

    @Test
    public void testStaticMethod() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method method = testClass.getMethod("staticPublicMethod", String.class);
        // static method doesn't need the instance/object of the class to invoke
        method.invoke(null, "Public Static");
        System.out.println("\n");
    }
}
