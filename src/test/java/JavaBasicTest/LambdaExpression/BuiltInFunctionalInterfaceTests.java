package JavaBasicTest.LambdaExpression;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class BuiltInFunctionalInterfaceTests {


    private <T> void print(T t, Consumer<T> consumerFunction) {
        consumerFunction.accept(t);
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
    public void testMyFunctionalInterface() {
        String s = combine(1, 4.5, "+", MyFunctionalInterface::combineThree);
        print(s, System.out::println);

        // non-static method cannot be refer from a static context
//        s = combine(2, 6, "-", MyFunctionalInterface::combineThreeDefault);
    }


    // define a functional interface by myself
    // functional interface can only has one single method
    // but it can override the method that inherit from Object,
        // for example, toString(), hashCode();
    // it can have static methods and default methods
    @FunctionalInterface
    interface MyFunctionalInterface {
        // target method
        // the only method allowed in functional interface
        String myMethod(Integer i, Double d, String s);

        // static methods
        static void print() {
            System.out.println("The static print method in MyFunctionalInterface triggered!");
        }

        static void print(String s) {
            System.out.println("The static print method in MyFunctionalInterface triggered!"
                                + "Your input String is: " + s);
        }

        // it is called outside, but in fact,
        // it shouldn't appear inside the interface
        // it's not good
        static String combineThree(Integer i, Double d, String s) {
            return String.format("%d %s %.3f = %s",i, s, d,  i + s + d);
        }

        default String combineThreeDefault(Integer i, Double d, String s) {
            return String.format("Combine Three : %d %s %.4f = %s",i, s, d,  i + s + d);
        }

        // default and static cannot be used at the same time
//        default static String combineThreeStaticDefault(Integer i, Double d, String s) {
//            return String.format("Combine Three : %d %s %.4f = %s",i, s, d,  i + s + d);
//        }

        default void printLine() {
            System.out.println("The default printLine method in MyFunctionalInterface triggered!");
        }

        default void printLine(String s) {
            System.out.println("The default printLine method in MyFunctionalInterface triggered!"
                    + "Your input String is: " + s);
        }
    }

    private String combine(Integer i, Double d, String s, MyFunctionalInterface myFunctionalInterface) {
        return myFunctionalInterface.myMethod(i, d, s);
    }
}
