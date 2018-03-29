package pers.xiaoming.notebook.basic.LambdaExpression;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class comparatorTest {


    private String[] getStringArray() {
        String[] strs = new String[]{"cnn", "voa", "abc", "bbc", "acc"};
        System.out.println("\n\n initialize a new String Array");
        printArray(strs);
        return strs;
    }

    private void printArray(String[] strs) {
        Stream.of(strs).forEach(str -> System.out.print(str + ", "));
    }

    @Test
    public void testAnonymousClassComparator() {
        String[] strs = getStringArray();
        anonymousClassComparator(strs);
        System.out.println("\n\n print String after Anonymous class comparator sort");
        printArray(strs);
    }


    private void anonymousClassComparator(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(o1.length()-1) - o2.charAt(o2.length()-1);
            }
        });
    }


    @Test
    public void testLambdaComparator() {
        String[] strs = getStringArray();
        lambdaComparator(strs);
        System.out.println("\n\n print String after Lambda comparator sort");
        printArray(strs);
    }

    private void lambdaComparator(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> o1.charAt(o1.length()-1) - o2.charAt(o2.length()-1));
    }



    @Test
    public void testComparingMethodComparator() {
        String[] strs = getStringArray();
        comparingFunction(strs);
        System.out.println("\n\n print String after comparing method comparator sort");
        printArray(strs);
    }

    /*
        Reports Comparators defined as lambda expressions which could be expressed using methods like Comparator.comparing().
        Some comparators like (person1, person2) -> person1.getName().compareTo(person2.getName()) could be simplified like this: Comparator.comparing(Person::getName).
        Also suggests to replace chain comparisons with Comparator.thenComparing(), e.g. int res = o1.first.compareTo(o2.first); if(res == 0) res = o1.second.compareTo(o2.second);
        if(res == 0) res = o1.third - o2.third; return res;
        will be replaced with objs.sort(Comparator.comparing((Obj o) -> o.first).thenComparing(o -> o.second).thenComparingInt(o -> o.third));
     */

    private void comparingFunction(String[] strs) {
        Arrays.sort(strs,
                Comparator.comparing(str -> str.charAt(str.length()-1)));
    }


    @Test
    public void testComparingMethodComparatorReverse() {
        String[] strs = getStringArray();
        Comparator<String> comparator = comparingFunctionReverse().reversed();
        Arrays.sort(strs, comparator.reversed());
        System.out.println("\n\n print String after comparing method comparator sort");
        printArray(strs);
    }

    private Comparator<String> comparingFunctionReverse() {
        return Comparator.comparing((String str) -> str.charAt(str.length()-1)).reversed();
    }


    @Test
    public void testThenComparing() {
        String[] strs = getStringArray();
        thenComparing(strs);
        System.out.println("\n\n print String using comparingInt() and thenComparing() methods ");
        printArray(strs);
    }

    // Also use comparingInt() here
    private void thenComparing(String[] strs) {
        Arrays.sort(strs,
                // Add Type to help compiler detect the type of Lambda Expression
                Comparator.comparingInt((String str) -> str.charAt(str.length()-1))
                        .thenComparingInt(str -> str.charAt(str.length()-2))
                        .thenComparing(str -> str.charAt(str.length()-3)));
    }
}
