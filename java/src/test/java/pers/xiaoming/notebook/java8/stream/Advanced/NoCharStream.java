package pers.xiaoming.notebook.java8.stream.Advanced;

import org.junit.Test;

import java.util.stream.Stream;

public class NoCharStream {

    @Test
    public void testStringToChars() {
        "Hello world!".chars().forEach(System.out::print);

        System.out.println();
        "Hello world!".chars().forEach( x -> System.out.print((char) x));
//        stream.of("Hello Worlds!").forEach(System.out::println);
    }


    @Test
    public void testCharArray() {
        char[] chars = {'a', 'b', 'c', 'd'};
        Stream.of(chars).forEach(System.out::println);
    }
}
