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


}
