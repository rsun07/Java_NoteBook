package pers.xiaoming.notebook.basic.util.generictype;

import pers.xiaoming.notebook.basic.entity.Person;
import pers.xiaoming.notebook.basic.entity.Student;
import pers.xiaoming.notebook.basic.entity.Worker;
import org.junit.Test;

import java.util.*;

public class GenericWildCard {
    public static void main(String args[]) {
        List<String> stringList = Arrays.asList("A", "B", "C");

        List<Person> people = Arrays.asList(
            new Person(1, "PBAA"),
            new Person(2, "PAAA"),
            new Person(3, "PABA"),
            new Person(4, "PAAAA"));

        List<Worker> workers = Arrays.asList(
            new Worker(11, "WBAA"),
            new Worker(12, "WAAA"),
            new Worker(13, "WABA"),
            new Worker(14, "WAAAA"));

        List<Student> students = Arrays.asList(
            new Student(21, "SBAA"),
            new Student(22, "SAAA"),
            new Student(23, "SABA"),
            new Student(24, "SAAAA"));

        printCollection(stringList);
        printCollection(people);
        printCollection(workers);
        printCollection(students);

        System.out.println("\n\n\n");

        // Cannot pass compiler because String not inherit from Person
//        printPersonCollection(stringList);
        printUpperCaseCollection(people);
        printUpperCaseCollection(workers);
        printUpperCaseCollection(students);

        System.out.println("\n\n\n");

        printLowerCasePersonCollection(people);

        // Cannot pass worker here
//        printLowerCasePersonCollection(workers);

        printLowerCasePersonCollection(students);


    }

    private static void printCollection(Collection<?> al) {
        Iterator<?> it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    // Cannot be the same name, the parameter is regarded as the same
//    private static void printCollection(Collection<? extends Person> al) {
//        printCollection(al);
//    }

    private static void printUpperCaseCollection(Collection<? extends Person> al) {
        printCollection(al);
    }

    private static void printLowerCasePersonCollection(Collection<? super Student> al) {
        printCollection(al);
    }

    @Test
    public void testUnboundedWildcardTypes() {
        List<String> strList = new ArrayList<>();
        strList.addAll(Arrays.asList("aa", "ab", "ba", "ac"));

        // use unbounded wild card type to get from strList
        for (Iterator<?> it = strList.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        List<?> list = strList;
        // equivalent to foreach statement in later Java version
        // unbounded wild card type doesn't affect the instance of behavior
        for(Object str : list) {
            System.out.println(str + " is a String instance ? : " + String.valueOf(str instanceof String));
        }

        // cannot insert into unbounded wild card type
        // the following line will trigger compiler error
        // list.add((Object) "de");
    }

}
