package JavaTest.JavaBasicTest.Stream.Advanced;

import org.junit.Test;

import java.util.stream.Stream;

public class NoCharStream {

    @Test
    public void testStringToChars() {
        "Hello world!".chars().forEach(System.out::print);

        System.out.println();
        "Hello world!".chars().forEach( x -> System.out.print((char) x));
//        Stream.of("Hello Worlds!").forEach(System.out::println);
    }


    @Test
    public void testCharArray() {
        char[] chars = {'a', 'b', 'c', 'd'};
        Stream.of(chars).forEach(System.out::println);
    }
}
