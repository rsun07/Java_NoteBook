package java.JavaBasicTest.Stream.BasicStreams;

import org.junit.Test;

import java.util.stream.Stream;

public class matchTest {

    /*
        Three match operations in Stream
        1. allMatch(), return true if all the elements in the Stream match the input predicate
        2. anyMatch(), return true if any one element in the Stream matches the input predicate
        3. noneMatch(), return true if all the elements in the Stream not match the input predicate
     */

    private Stream<Integer> getStream() {
        return Stream.of(1,2,3,4,5,6,7,8);
    }

    @Test
    public void testAllMatch() {
        Stream<Integer> inputStream = getStream();

        // allMatch
        boolean allMatch = inputStream.allMatch(i -> i > 0);
        System.out.println(allMatch);

        inputStream = getStream();
        allMatch = inputStream.allMatch(i -> i > 1);
        System.out.println(allMatch);
    }

    @Test
    public void testAnyMatch() {
        Stream<Integer> inputStream = getStream();

        // allMatch
        boolean anyMatch = inputStream.anyMatch(i -> i == 8);
        System.out.println(anyMatch);

        inputStream = getStream();
        anyMatch = inputStream.anyMatch(i -> i == 0);
        System.out.println(anyMatch);
    }

    @Test
    public void testNoneMatch() {
        Stream<Integer> inputStream = getStream();

        // allMatch
        boolean noneMatch = inputStream.noneMatch(i -> i == 0);
        System.out.println(noneMatch);

        inputStream = getStream();
        noneMatch = inputStream.noneMatch(i -> i == 8);
        System.out.println(noneMatch);
    }
}
