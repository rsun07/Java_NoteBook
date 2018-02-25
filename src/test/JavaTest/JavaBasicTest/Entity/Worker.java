package JavaTest.JavaBasicTest.Entity;

public class Worker extends Person {
    public Worker(int age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return "Worker{" +
            "age=" + getAge() +
            ", name='" + getName() + '\'' +
            '}';
    }
}
