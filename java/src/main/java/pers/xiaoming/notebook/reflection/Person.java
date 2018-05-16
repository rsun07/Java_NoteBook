package pers.xiaoming.notebook.reflection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Person {

    public String name = "person_name";
    private int age = 23;

    public Person() {
        System.out.println("Person default constructor");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("Person name constructor");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person name and age constructor");
    }

    private Person(List list) {
        System.out.println("Person List private constructor");
    }

    Person(Map map) {
        System.out.println("Person Map default access constructor");
    }

    public void noArgPublicMethod() {
        System.out.println("Function without parameter called");
    }

    public void oneArgPublicMethod(String str) {
        System.out.println(str);
    }

    public void twoArgsPublicMethod(String str, int i) {
        System.out.println(str + " " + i);

    }

    private Class[] privateMethod(String str, int[] password) {
        System.out.println(str);
        System.out.println("passwords: " + Arrays.toString(password));
        return new Class[]{Boolean.class, Float.class};
    }

    void defaultAccessMethod(String str) {
        System.out.println(str);
    }

    void protectedAccessMethod(String str) {
        System.out.println(str);
    }

    public static void staticPublicMethod(int i) {
        System.out.println("Static Function with one int parameter called : i = " + i);
    }
}
