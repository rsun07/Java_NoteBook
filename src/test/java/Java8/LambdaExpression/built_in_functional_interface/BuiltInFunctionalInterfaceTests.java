package Java8.LambdaExpression.built_in_functional_interface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 *
 * Consumer<T> : void accept (T t);
 * Supplier<T> : T get();
 * Function<T, R> : R apply (T t);
 * Predicate<T> : boolean test(T t);
 *
 */
public class BuiltInFunctionalInterfaceTests {

    // Test for Consumer!
    private <T> void print(T t, Consumer<T> consumerFunction) {
        consumerFunction.accept(t);
    }

    @Test
    public void testFunction() {
        print(
                // this will still trigger the second function as the input is a String
                // translate("1.33", Double::valueOf),

                // this will trigger the generic type / parameterized type method
                translate(new Float("-1.45"), Double::valueOf),
                System.out::println
        );

        print(
                translate("-123", (str) -> Integer.valueOf(str)),
                System.out::println
        );

        print(
                translate("-321", /* using method reference */ Integer::valueOf),
                System.out::println
        );
    }

    private <T, R> R translate(T t, Function<T, R> function) {
        return function.apply(t);
    }

    // this is regarded as a different as the generic / parameterized type function above
    private Integer translate(String string, Function<String, Integer> translateFunction) {
        return translateFunction.apply(string);
    }


    @Test
    public void testSupplier() {
        List<Integer> nums1 = getNumList(7,
                () -> {
                    Random random = new Random();
                    return random.nextInt(88);
                });
        print(nums1, System.out::println);

        List<Integer> nums2 = getNumList(3,  () -> (int) (Math.random() * 100));
        print(nums2, System.out::println);

    }

    private List<Integer> getNumList(int size, Supplier<Integer> intGenerator) {
        List<Integer> nums = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            nums.add(intGenerator.get());
        }

        return nums;
    }


    @Test
    public void testPredicate() {
        List<String> list = Arrays.asList("Hello", "aa", "Di", "KTV", "abc");

        List<String> result = strFilter(list, str -> str.length() >= 3);
        System.out.println(result);

        result = strFilter(list,
                            str -> {
                                char[] chars = str.toCharArray();
                                for (char ch : chars) {
                                    if (ch >= 'A' && ch <= 'Z') {
                                        return true;
                                    }
                                }
                                return false;
                            });
        System.out.println(result);
    }

    private List<String> strFilter(List<String> strList, Predicate<String> predicate) {
        List<String> newList = new ArrayList<>();

        for (String str : strList) {
            if (predicate.test(str)) {
                newList.add(str);
            }
        }
        return newList;
    }




    @Test
    public void testUnaryOperator() {
        // functional programming
        // functional interface
        print(
                encode("AAA", String::toLowerCase),
                System.out::println);

        //=========================================================================
        // traditional way
        String returnStr = encode("BBB", (stringParameter) -> stringParameter.toLowerCase());

        print(returnStr, (t) -> System.out.println(t));
        //System.out.println(returnStr);
    }

    // functional interface is used to receive a function from Lambda
    // in another words, used as a type for a Lambda described method
    private <T> T encode(T t, UnaryOperator<T> encodeFunction) {
        return encodeFunction.apply(t);
    }
}
