package java.JavaBasicTest.Stream.BasicStreams;

import org.junit.Test;

import java.util.stream.Stream;

public class peekTest {
    @Test
    public void peekTest() {
        // peek is similar to forEach,
        // but peek is intermediate operation but forEach is terminate operation
        // peek will do the operation passed through
        Stream<String> inputStream = getInputStream();


        System.out.println("\n\nPrint input Stream through peek() and get a new Stream");
        // in fact this won't print each String out to the console
        // the print will print the result into the intermediateStream
        Stream<String> intermediateStream =
                inputStream.peek(System.out::print);

        System.out.println("\n\nPrint intermediate Stream through forEach()");
        intermediateStream.forEach(System.out::print);
    }

    @Test
    public void peekTwiceTest() {
        Stream<String> inputStream = getInputStream();

        System.out.println("\n\nPrint input Stream through peek() and get a new Stream");
        Stream<String> intermediateStream =
                inputStream
                    // if do it without the print, the result of replace() will be ignored
                    // if you still want to replace '_' to '*',
                        // you should use map() instead of (peek)
                    .peek(str -> System.out.print(str.replace('_', '*')));

        System.out.println("\n\nPrint intermediate Stream through forEach()");
        // from the result we can see, the peek() result was inserted before the original String
        intermediateStream.forEach(System.out::print);
    }

    private Stream<String> getInputStream() {
        String[] strs = {"__one__", "__two__", "__three__"};
        return Stream.of(strs);
    }
}
