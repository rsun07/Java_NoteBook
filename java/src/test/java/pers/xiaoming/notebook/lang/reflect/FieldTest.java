package pers.xiaoming.notebook.lang.reflect;

import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Field;

@Ignore("demo test")
public class FieldTest extends TestBase {
    @Test
    public void printAllFields() {
        System.out.println("\nPublic Fields as following: ");
        for (Field field : testClass.getFields()) {
            System.out.println("Method is :" + field);
        }

        System.out.println("\nDeclared Fields as following: ");
        for (Field field : testClass.getDeclaredFields()) {
            System.out.println("Method is :" + field);
        }
    }

    @Test
    public void testPublicField() throws NoSuchFieldException, IllegalAccessException {
        Field field = testClass.getField("name");
        getAndPrintField(field);

        field.set(person, "updated_name");
        getAndPrintField(field);
    }

    @Test
    public void testPrivateField() throws NoSuchFieldException, IllegalAccessException {
        Field field = testClass.getDeclaredField("age");
        field.setAccessible(true);
        getAndPrintField(field);

        field.set(person, 888);
        getAndPrintField(field);
    }

    private void getAndPrintField(Field field)
            throws IllegalAccessException {

        Object value = field.get(person);
        Class type = field.getType();
        if (type.equals(String.class)) {
            String strValue = (String) value;
            System.out.println("String value is " + strValue);
        } else if (type.equals(int.class)) {
            int intValue = (int) value;
            System.out.println("int value is " + intValue);
        }
        System.out.println();
    }
}
