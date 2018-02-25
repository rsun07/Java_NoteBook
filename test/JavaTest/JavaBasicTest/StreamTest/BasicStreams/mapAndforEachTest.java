package JavaTest.JavaBasicTest.StreamTest.BasicStreams;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mapAndforEachTest {
    @Test
    public void testMapStream() {
        List<String> words = Arrays.asList("Ab", "AA", "Ac", "Dc", "cD", "cd");
        System.out.println("Original words list: \n" + words.toString());
        List<String> result = words.stream()
                                .map(String::toLowerCase)
                                .collect(Collectors.toList());
        System.out.println("list after stream to lower case: \n" + result);
    }

    @Test(expected = IllegalStateException.class)
    // flatMap is used to 1:many reflection

    // also Test forEach() and peek()
    public void testFlatMapAndForEach() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );

        // no list anymore, even not stream into one single list
        // but stream into a stream of Integer
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());

        // this only print the memory reference of the outputStream
        // flatMap is only a Intermediate stream operation
        System.out.println("\nPrint output Stream memory reference");
        System.out.println(outputStream);


        System.out.println("\n\nPrint outputStream using forEach()");
        outputStream.forEach(System.out::print);

        // stream already ended, won't print again
        // java.lang.IllegalStateException: stream has already been operated upon or closed
        try {
            System.out.println("\n\nPrint outputStream after forEach()");
            System.out.println(outputStream);
            outputStream.forEach(System.out::print);
        } catch (IllegalStateException e) {
            System.out.println("\n\n outputStream already ended, get the following exception");
            System.out.println("\texception cause: " + e.getCause());
            System.out.println("\texception message: " + e.getMessage());
            throw e;
        }
    }
}
