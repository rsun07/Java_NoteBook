package Java8.LambdaExpression.customizedFunctionalInterface;

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
}
