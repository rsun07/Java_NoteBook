package basic.util.ObjectMethods;

import basic.util.GenericType.PersonAgeComparitor;
import basic.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class CompareFunctions {
    public static void main(String args[]) {
        TreeSet<Person> personSortByNameSet = new TreeSet<>();
        TreeSet<Person> personSortByAgeSet = new TreeSet<>(new PersonAgeComparitor());

        List<Person> people = Arrays.asList(
            new Person(1, "BAA"),
            new Person(2, "AAA"),
            new Person(3, "ABA"),
            new Person(4, "AAAA"));

        personSortByNameSet.addAll(people);
        personSortByAgeSet.addAll(people);

        System.out.println(personSortByAgeSet);
        System.out.println(personSortByNameSet);
    }
}
