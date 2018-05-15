package pers.xiaoming.notebook.io.serialization.entity;

import java.io.Serializable;
import java.util.Objects;

public class MySerializableObject implements Serializable {
    private String name;
    private int age;
    private transient int salary;

    public MySerializableObject() {
    }

    public MySerializableObject(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySerializableObject that = (MySerializableObject) o;
        return age == that.age &&
                salary == that.salary &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, salary);
    }
}
