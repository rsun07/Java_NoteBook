package JavaTest.JavaBasicTest.Entity;

public class Student extends Person {
    public Student(int age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return "Student{" +
            "age=" + getAge() +
            ", name='" + getName() + '\'' +
            '}';
    }
}