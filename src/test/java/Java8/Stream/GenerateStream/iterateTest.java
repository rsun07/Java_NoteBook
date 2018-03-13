package java.JavaBasicTest.Stream.GenerateStream;

import org.junit.Test;

import java.util.stream.Stream;

public class iterateTest {
    // iterate() just like reduce(),
    // it need a seed (start value) and a UnaryOperator( f(x) )
    // then it based on the seed and f(x) to generate the Stream

    @Test
    public void testIterate() {
        Stream.iterate(0, x -> x + 2)
                .limit(10)
                .forEach(System.out::println);
    }


    @Test
    public void testMyIterate() {
        Stream.iterate(0, x -> new Fibonacci().next())
                .limit(20)
                .forEach(System.out::println);

    }

    @Test
    public void testNoneStreamFibonacci() {
        for (int i=0; i<10; i++) {
            System.out.println(new Fibonacci().next());
        }
    }
}




class Fibonacci {
    private static int pre;
    private static int current;
    private static boolean isConstructed = false;

    Fibonacci() {
        if (!isConstructed) {
            current = 1;
            pre = 1;
            isConstructed = true;
        }
    }

    int next() {
        int temp = current;
        current = pre + current;
        pre = temp;
        return current;
    }
}
