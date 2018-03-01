package JavaTest.JavaBasicTest.Stream.Advanced;

import org.junit.Test;

import java.util.stream.Stream;

public class StreamExceptionTest {

    @Test
    public void testStreamException() {
        Stream.of(1, 2, 0, 5).filter(x -> 2 / x > 0).forEach(System.out::println);
    }
}
