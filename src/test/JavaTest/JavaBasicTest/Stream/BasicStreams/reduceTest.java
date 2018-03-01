package JavaTest.JavaBasicTest.Stream.BasicStreams;

import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class reduceTest {
    // reduce combine all the Stream elements using BinaryOperator
    // start value (seed) is optional,
        //  if there is start value, the return type will the the same as the Stream elements
        // if no start value, the return type will be Optional class
    // You can say sum, min, max, average are all special case of reduce

    @Test
    public void testReduceWithStartValue() {
        double min = Stream.of(1.4, 1.2, 34.5, -23.0, -20.5)
                .reduce(Double.MIN_VALUE, Double::min);
        System.out.println(min);


        String concatStr = Stream.of("a", "B", "c", "D", "e", "f")
                .filter(c -> c.compareTo("Z") > 0)
                .reduce("", String::concat);

        System.out.println(concatStr);
    }

    @Test
    public void testReduceWithoutStartValue() {
        OptionalDouble opDb = IntStream.of(1, 3, 4, 5).average();

        // verbose
        System.out.println(opDb.isPresent() ? opDb.getAsDouble() : opDb.orElse(Double.MIN_VALUE));

        Optional<Integer> op = Stream.of(1,2,3,4).reduce(Integer::sum);
        // concise, succinct
        op.ifPresent(System.out::println);
    }

}
