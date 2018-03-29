package pers.xiaoming.notebook.java8.stream.Advanced;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ToMapTest {

    private List<Person> persons;

    @Before
    public void setUp() {
        persons =  Arrays.asList(
                new Person("John", 22, "CA"),
                new Person("Smith", 22, "CA"),
                new Person("Marry", 32, "CA"),
                new Person("Zina", 32, "CA"),
                new Person("Mike", 32, "NY"),
                new Person("Pi", 22, "PA"),
                new Person("Kobe", 32, "NJ"),
                new Person("Lee", 28, "WA")
        );
    }

    @Test(expected = IllegalStateException.class)
    public void testSimpleToMap() {
        Map<Integer, Person> result =
                persons.stream().collect(
                    // cannot have duplicate key
                    // in another words, cannot have duplicate key with different value
                    /* the 'e' here means the stream element, each instance of Person in this method */
                    Collectors.toMap(Person::getAge, e->e)
            );

        System.out.println(result);

    }


    @Test
    public void testToMapThreeVariable() {
        Map<String, Person> result =
                persons.stream().collect(
                        // the toMap here means the following:
                        // Construct a new Map, the key is the 'state'
                        // the value is the Person's instance
                        // if there is duplicate persons from the same state
                        // use the person has the eldest age
                        Collectors.toMap(
                                Person::getState,
                                e->e, /* the 'e' here means the stream element, each instance of Person in this method */
                                BinaryOperator.maxBy(
                                        Comparator.comparing(Person::getAge).thenComparing(Person::getName))
                        )
                );

        /*
            // Collector to impose last-write-wins policy
            toMap(keyMapper, valueMapper, (v1, v2) -> v2)
         */

        System.out.println(result);

    }

    @Test
    public void testToMapFourVariable() {
        Map<String, Person> result =
                persons.stream().collect(
                        // the toMap here means the following:
                        // Construct a new Map, the key is the 'state'
                        // the value is the Person's instance
                        // if there is duplicate persons from the same state
                        // use the person has the eldest age
                        Collectors.toMap(
                                Person::getState,
                                e->e, /* the 'e' here means the stream element, each instance of Person in this method */
                                BinaryOperator.maxBy(
                                        Comparator.comparing(Person::getAge).thenComparing(Person::getName)),
                                ConcurrentHashMap::new
                        )
                );

        /*
            // Collector to impose last-write-wins policy
            toMap(keyMapper, valueMapper, (v1, v2) -> v2)
         */

        System.out.println(result.getClass());

    }

    @Test
    public void testToMapGroupingBy() {
        System.out.println("\n\n");
        Map<String, List<Person>> result =
                persons.stream().collect(
                            Collectors.groupingBy(Person::getState));
        System.out.println(result);


        System.out.println("\n\n");
        Map<Integer, Long> result2 =
                persons.stream().collect(
                        Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println(result2);


        System.out.println("\n\n");
        Map<Integer, List<Person>> result3 =
                persons.stream().collect(
                        Collectors.groupingBy(Person::getAge));
        System.out.println(result3);
    }

    @Data
    @AllArgsConstructor
    class Person {
        private String name;
        private Integer age;
        private String state;
    }
}
