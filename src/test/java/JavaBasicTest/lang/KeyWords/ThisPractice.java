package JavaBasicTest.lang.KeyWords;


public class ThisPractice {
    /*
    this的核心原理: (最基本应用)
    简单说,哪个对象调用了this所在函数,this就代表哪个对象。
    this就是所在函数所属对象的引用。
    1. 用于局部变量 (local variable) 和成员变量 (member variable) 重名的时候
     */

    /*
    一个类中的成员 (成员变量 或者 方法), 想要被调用, 一定要有对象调用。
    很多时候调用内部方法和成员, 其实是省略了this.
     */


    public static void main(String[] args) {
        System.out.println(new PersonNoName("abc").getName());
        System.out.println(new PersonWithName("abc").getName());

    }
}


class Person {
    // *** If name is private, then subclass cannot access it

    String name;
    Integer age;

    public String getName() {
        return name;
    }

    // third place to use this
    public boolean compare(Person p) {
        return (this.age == p.age);
    }
}

class PersonNoName extends Person {

    // in constructor, local variable name assigns to itself
    // So the member variable name is still null;
    public PersonNoName(String name) {
        name = name;
    }
}

class PersonWithName extends Person {

    // The second place to use this, when refer to another constructor
    // Only constructor can call another constructor
    // Must in the first line of one constructor to call another constructor
    public PersonWithName(String name) {
//        int age = 0;
        this(name, null);
    }

    // in constructor, local variable name assigns to itself
    // So the member variable name is still null;
    public PersonWithName(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}