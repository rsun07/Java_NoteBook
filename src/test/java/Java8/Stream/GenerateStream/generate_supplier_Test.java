package Java8.Stream.GenerateStream;

import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class generate_supplier_Test {
    @Test
    public void testSimpleGenerateSupplier() {
        Supplier<Integer> randomInt = new Random()::nextInt;

        // equals to the following line in lambda
        // just review method reference here :)
        Supplier<Integer> supplier = () -> new Random().nextInt(20);

        Stream.generate(supplier)
                .limit(20)
                .filter(i -> i%2==0)
                .forEach(System.out::println);
    }

    @Test
    public void testGenerateAnonymousSupplier() {
        Stream.generate(() -> System.currentTimeMillis() % 100)
                .limit(20)
                .distinct()
                .forEach(System.out::println);
    }


    @Test
    public void testSelfImplementedSupplier() {
        Stream.generate(new MySupplier())
                .distinct()
                .limit(20)
                .forEach(System.out::println);
    }

    private class MySupplier implements Supplier<Long> {
        @Override
        public Long get() {
            return System.currentTimeMillis() % 100;
        }
    }

    // From the infinite Stream we can see
    // "Stream pipelines are evaluated lazily: evaluation doesn’t start until the terminal operation is invoked"
    // This means only for every single element in the Stream, not the who Stream
    // Each element is an input, for each element, it won't operation during the intermediate pipeline, it execute until the terminal operation
    // But for the whole stream, the first element may already executed by the terminal operation but the 100th element haven't go into the Stream
    @Test
    public void testInfiniteStream() {
        Stream.generate(() -> new Random().nextInt(100))
                .forEach(i -> print(i));

        // never get executed because the previous Stream is infinite
        Stream.generate(() -> new Random().nextInt(100))
                .forEach(generate_supplier_Test::print2);
    }

    private static void print(int i) {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread() + " print: " + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void print2(int i) {
        try {
            Thread.sleep(5*1000);
            System.out.println(Thread.currentThread() + " print2: " + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInfiniteParallelStream() {
        Stream.generate(() -> new Random().nextInt(100))
                .parallel().forEach(generate_supplier_Test::print2);
    }
}
