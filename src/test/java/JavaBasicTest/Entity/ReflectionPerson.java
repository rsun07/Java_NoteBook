package JavaBasicTest.Entity;

import java.util.Arrays;
import java.util.List;

public class ReflectionPerson {

    public String name = "person_name";
    private int age = 23;

    public ReflectionPerson() {
        System.out.println("ReflectionPerson default constructor");
    }

    public ReflectionPerson(String name) {
        this.name = name;
        System.out.println("ReflectionPerson name constructor");
    }

    public ReflectionPerson(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("ReflectionPerson name and age constructor");
    }

    private ReflectionPerson(List list) {
        System.out.println("ReflectionPerson List private constructor");
    }




    public void method() {
        System.out.println("Function without parameter called");
    }

    public void method(String str) {
        System.out.println(str);
    }

    private Class[] method(String str, int[] password) {
        System.out.println(str);
        System.out.println("passwords: " + Arrays.toString(password));
        return new Class[]{Boolean.class, Float.class};
    }

    public static void method(int i) {
        System.out.println("Static Function with one int parameter called : i = " + i);
    }

}
