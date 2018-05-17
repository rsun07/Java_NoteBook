package pers.xiaoming.notebook.reflection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Person {

    public String name = "person_name";
    private int age = 23;

    public Person() {
        printConstructorMsg("Public No Arg");
    }

    public Person(String name) {
        this.name = name;
        printConstructorMsg("Public One Arg");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        printConstructorMsg("Public Two Args");
    }

    private Person(List list) {
        printConstructorMsg("Private");
    }

    Person(Map map) {
        printConstructorMsg("Default Access");
    }

    public void noArgPublicMethod() {
        printMethodMsg("no arg public", null);
    }

    public void oneArgPublicMethod(String str) {
        printMethodMsg("one arg public", str);
    }

    public void twoArgsPublicMethod(String str, int myInt) {
        printMethodMsg("two args public", str + " " + myInt);
    }

    private void privateMethod(String str) {
        printMethodMsg("private", str);
    }

    void defaultAccessMethod(String str) {
        printMethodMsg("default access", str);
    }

    protected void protectedAccessMethod(String str) {
        printMethodMsg("protected", str);
    }

    public static void staticPublicMethod(String str) {
        printMethodMsg("static", str);
    }

    private static void printConstructorMsg(String accessLevel) {
        System.out.println("Invoke " + accessLevel + " Constructor" );
    }

    private static void printMethodMsg(String accessLevel, String str) {
        System.out.println("Invoke " + accessLevel + " Method with message: " + str);
    }
}
