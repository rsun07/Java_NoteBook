package JavaTest.JavaBasicTest.equalsHashCode;

import JavaTest.JavaBasicTest.Entity.Person;
import org.junit.Test;

public class hashCodeTest {

    @Test
    public void testHashCodeLomBok() {
        Person person1 = new Person(22, "John");
        Person person2 = new Person(22, "John");
        Person person3 = new Person(23, "John");


        /*
            2319318
            2319318
            2319377

         */
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());
    }
}
