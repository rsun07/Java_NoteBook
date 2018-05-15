package pers.xiaoming.notebook.io.serialization.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonXML {
    private String name;
    private int age;
    private transient int salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonXML that = (PersonXML) o;
        return age == that.age &&
                salary == that.salary &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, salary);
    }
}
