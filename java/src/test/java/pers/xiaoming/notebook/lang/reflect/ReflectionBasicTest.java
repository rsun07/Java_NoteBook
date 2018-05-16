package pers.xiaoming.notebook.lang.reflect;

import org.junit.Test;
import pers.xiaoming.notebook.reflection.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionBasicTest {

    @Test
    // test get fields
    public void testFields() throws Exception {
        Class clazz = Class.forName("basic.entity.Person");
        Constructor c = clazz.getConstructor(null);
        Person p = (Person) c.newInstance();
        System.out.println("\n");

        Field field = clazz.getField("name");
        getAndPrintField(clazz, p, field);
        System.out.println("\n");

        field.set(p, "updated_name");
        getAndPrintField(clazz, p, field);
        System.out.println("\n");

        field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        getAndPrintField(clazz, p, field);
        System.out.println("\n");

        field.set(p, 32);
        getAndPrintField(clazz, p, field);
        System.out.println("\n");
    }

    private void getAndPrintField(Class clazz, Person p, Field field)
            throws NoSuchFieldException, IllegalAccessException {

        Object value = field.get(p);
        Class type = field.getType();
        if (type.equals(String.class)) {
            String strValue = (String) value;
            System.out.println("String value is " + strValue);
        } else if (type.equals(int.class)) {
            int intValue = (int) value;
            System.out.println("int value is " + intValue);
        }
    }

    @Test
    // test get fields
    public void testOtherFunctions() throws Exception {
        Class clazz = Class.forName("basic.entity.Person");
        System.out.println("\n");

        System.out.println("Package is :" + clazz.getPackage());
        System.out.println("Name is :" + clazz.getName());
        System.out.println("Simple Name is :" + clazz.getSimpleName());
        System.out.println("Type Name is :" + clazz.getTypeName());

        System.out.println("Superclass is :" + clazz.getSuperclass());
        System.out.println("Modifiers is :" + clazz.getModifiers());


        System.out.println("\nDeclared Fields as following: ");
        for (Field field : clazz.getDeclaredFields())
            System.out.println("Method is :" +  field);

    }
}
