package pers.xiaoming.notebook.lang.reflect;

import org.junit.BeforeClass;
import org.junit.Test;
import pers.xiaoming.notebook.entity.ReflectionPerson;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ConstructorTest extends TestBase {

    @BeforeClass
    public static void setup() throws ClassNotFoundException {
        testClass = Class.forName(TEST_CLASS);
    }

    @Test
    public void testNoArgConstructor() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        @SuppressWarnings("unchecked")
        Constructor constructor = testClass.getConstructor();
        ReflectionPerson person = (ReflectionPerson) constructor.newInstance();
        printName(person);

        System.out.println("\tAnother way to create new instance, Only allowed for no arg constructor");
        printName((ReflectionPerson) testClass.newInstance());
    }

    @Test
    public void testOneArgConstructor() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        @SuppressWarnings("unchecked")
        Constructor constructor = testClass.getConstructor(String.class);
        ReflectionPerson person = (ReflectionPerson) constructor.newInstance("String Constructor");
        printName(person);
    }

    @Test
    public void testTwoParamConstructor() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        @SuppressWarnings("unchecked")
        Constructor constructor = testClass.getConstructor(String.class, int.class);
        ReflectionPerson person = (ReflectionPerson) constructor.newInstance("String and int Constructor", 12);
        printName(person);
    }

    @Test
    public void testPrivateConstructor() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        @SuppressWarnings("unchecked")
        Constructor constructor = testClass.getDeclaredConstructor(List.class);

        constructor.setAccessible(true);

        ReflectionPerson person = (ReflectionPerson) constructor.newInstance(new ArrayList<>());
        printName(person);
    }

    private void printName(ReflectionPerson person) {
        System.out.printf("Name for the person is : %s\n", person.name);
        System.out.println();
    }
}
