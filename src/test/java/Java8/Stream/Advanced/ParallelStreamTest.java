package Java8.Stream.Advanced;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelStreamTest {

    @Test
    public void test() {
        System.out.println("=================================");
        System.out.println("Using Sequential Stream");
        System.out.println("=================================");
        int[] array= {1,2,3,4,5,6,7,8,9,10};
        IntStream intArrStream = Arrays.stream(array);
        intArrStream.forEach(s->
                    System.out.println(s+" "+Thread.currentThread().getName())
        );

        System.out.println("\n\n\n");
        System.out.println("=================================");
        System.out.println("Using Parallel Stream");
        System.out.println("=================================");
        IntStream intParallelStream = Arrays.stream(array).parallel();
        intParallelStream.forEach(s->
                    System.out.println(s+" "+Thread.currentThread().getName())
        );
    }


    private static final long CALCULATOR_END_INPUT = 100000000000L;

    @Test
    public void testForkJoin() {
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculator(0L, CALCULATOR_END_INPUT);
        Long sum = pool.invoke(task);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getNano() / 1000000);
    }

    @Test
    public void testTraditionalFor() {
        Instant start = Instant.now();

        long sum = 0L;

        for (long i = 0; i < CALCULATOR_END_INPUT; i++) {
            sum += i;
        }

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getNano() / 1000000);
    }

    @Test
    public void testParallelStream() {
        Instant start = Instant.now();

        LongStream.rangeClosed(0, CALCULATOR_END_INPUT).parallel().reduce(0, Long::sum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getNano() / 1000000);
    }
}
