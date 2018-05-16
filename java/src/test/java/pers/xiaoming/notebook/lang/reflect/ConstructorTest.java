package pers.xiaoming.notebook.lang.reflect;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.reflection.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Ignore("demo test")
public class ConstructorTest extends TestBase {

    @BeforeClass
    public static void setup() throws ClassNotFoundException {
        testClass = Class.forName(TEST_CLASS);
    }

    @Test
    public void testGetAllConstructors() {
        System.out.println("\nPublic Constructors as following: ");
        for (Constructor constructor : testClass.getConstructors())
            System.out.println("Constructor is :" +  constructor);

        System.out.println("\nDeclared Constructors as following: ");
        for (Constructor constructor : testClass.getDeclaredConstructors())
            System.out.println("Constructor is :" +  constructor);

        System.out.println();
    }

    @Test
    public void testNoArgConstructor() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        @SuppressWarnings("unchecked")
        Constructor constructor = testClass.getConstructor();
        Person person = (Person) constructor.newInstance();
        printName(person);

        System.out.println("\tAnother way to create new instance, Only allowed for no arg constructor");
        printName((Person) testClass.newInstance());
    }

    @Test
    public void testOneArgConstructor() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        @SuppressWarnings("unchecked")
        Constructor constructor = testClass.getConstructor(String.class);
        Person person = (Person) constructor.newInstance("String Constructor");
        printName(person);
    }

    @Test
    public void testTwoParamConstructor() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        @SuppressWarnings("unchecked")
        Constructor constructor = testClass.getConstructor(String.class, int.class);
        Person person = (Person) constructor.newInstance("String and int Constructor", 12);
        printName(person);
    }

    @Test
    public void testPrivateConstructor() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        @SuppressWarnings("unchecked")
        Constructor constructor = testClass.getDeclaredConstructor(List.class);

        constructor.setAccessible(true);

        Person person = (Person) constructor.newInstance(new ArrayList<>());
        printName(person);
    }

    @Test(expected = IllegalAccessException.class)
    public void testPrivateConstructorFail() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        @SuppressWarnings("unchecked")
        Constructor constructor = testClass.getDeclaredConstructor(List.class);
        System.out.println(constructor);

        // still able to get the constructor, but don't have access to it

        try {
            Person person = (Person) constructor.newInstance(new ArrayList<>());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void printName(Person person) {
        System.out.printf("Name for the person is : %s\n", person.name);
        System.out.println();
    }
}
