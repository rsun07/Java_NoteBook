package JavaTest.JavaBasicTest.Stream.BasicStreams;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Optional_getFirst_Test {
    // findFirst() is a terminal AND short-circuiting operation
    // The key here is the return type of findFirst()
    // Optional
    @Test
    public void optionalTest() {
        String strA = " abcd", strB = null;
        System.out.printf(
            "String A length using Java 8 :%d \n " +
            "String A length using traditional: %d \n " +
            "String B length using Java 8 :%d \n " +
            "String B length using traditional: %d \n ",
                getLengthJava8(strA),
                getLengthTraditional(strA),
                getLengthJava8(strB),
                getLengthTraditional(strB)
        );
    }

    // Java 8 implementation
    private int getLengthJava8(String text) {
        Optional.ofNullable(text).ifPresent(System.out::println);
        return Optional.ofNullable(text).map(String::length).orElse(-1);
    }

    // traditional implementation
    private int getLengthTraditional(String text) {
        if (text != null) {
            System.out.println(text);
            return text.length();
        } else {
            return -1;
        }
    }


    @Test
    public void testGetFirst() {
        // find first is not "Give a input, find the first appearance of it"
        // But return First in the stream, or get First element from the stream
        List<Integer> list = Arrays.asList(1, 2, -3, 4, 2, 3, -5, 4);
        Optional<Integer> op = list.stream().findFirst();
        System.out.println("Result for findFirst()");
        op.ifPresent(System.out::println);

        // Optional is not like Stream that will close after call
        op.ifPresent(System.out::println);


        // test findAny()
        System.out.println("Result for findAny()");
        op = list.stream().findAny();
        op.ifPresent(System.out::println);

        // test findMax()
        System.out.println("Result for max() with Integer compareTo");
        op = list.stream().max(Integer::compareTo); // looks like this is a Java built in method reference?
        op.ifPresent(System.out::println);

        op = list.stream().max(
                /* need a instance method reference or lambda expression here
                    But can be replace by their qualifier
                    For example,
                    max(r -> r.run()) == max(r)

                    because functional interface has only one non static and non default method


                    The reminder from IDE
                    This inspection reports method references or lambda expressions which point to a method of their own functional interface type and hence can be replaced with their qualifiers, like
                    SwingUtilities.invokeLater(r::run);
                    SwingUtilities.invokeAndWait(() -> r.run());
                    can be replaced with
                    SwingUtilities.invokeLater(r);
                    SwingUtilities.invokeAndWait(r)
                 */
                new AbsComparator());
        op.ifPresent(System.out::println);

        op = list.stream().max(new AbsComparator()::compare);
        op.ifPresent(System.out::println);

        // the following line doesn't work even change AbsComparator to a static class
        //op = list.stream().max(AbsComparator::compare);

        op = list.stream().max(StaticAbsComparator::compare);
        op.ifPresent(System.out::println);


//        op = list.stream().max(i -> new Comparator<Integer>() {} );
//        op.ifPresent(System.out::println);
    }

    private class AbsComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return abs(i1).compareTo(abs(i2));
        }

        private Integer abs(Integer i) {
            return i > 0 ? i : -1;
        }
    }

    private static class StaticAbsComparator {
        static int compare(Integer i1, Integer i2) {
            return abs(i1).compareTo(abs(i2));
        }

        private static Integer abs(Integer i) {
            return i > 0 ? i : -1;
        }
    }
}
