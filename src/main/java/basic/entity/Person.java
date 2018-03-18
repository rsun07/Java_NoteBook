package basic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Comparable<Person> {
    private Integer age;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
            "age=" + age +
            ", name='" + name + '\'' +
            '}';
    }

    @Override
    public int compareTo(Person person) {
        int diff = this.getName().compareTo(person.getName());
        return diff == 0 ? this.getAge().compareTo(person.getAge()) : diff;
    }
}
