package pers.xiaoming.notebook.util.generictype;

import pers.xiaoming.notebook.entity.Person;

import java.util.Comparator;

/*
 *  Comparator has a function compare,
 *  which is used to compare two Object,
 *  the inputs are two Object.
 *
 *  Comparable is the the nature order of the class.
 *  It's compareTo function is to compare the object it self with Object of the same class.
 *
 */

// This makes Person sort by age first then name
public class PersonAgeComparitor implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        if (person1 == person2) {
            return 0;
        } else if (person1 == null) {
            return -1;
        } else if (person2 == null) {
            return 1;
        } else {
            int diff = person1.getAge() - person2.getAge();
            return diff == 0 ? person1.getName().compareTo(person2.getName()) : diff;
        }
    }
}
