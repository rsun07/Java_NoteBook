package JavaTest.JavaBasicTest.Stream.BasicStreams;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class filterTest {
    @Test
    public void filterTest() {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] evenNums =
                Stream.of(nums)
                .filter(n -> n % 2 == 0)
                .toArray(Integer[]::new);

        // java print array only print the memory reference
        System.out.println("\n Print evenNums array directly");
        System.out.println(evenNums);

        System.out.println("\n Print evenNums array toString()");
        System.out.println(evenNums.toString());

        // First, traditional way to print a Array
        System.out.println("\n Transfer array to List then print");
        System.out.println(Arrays.asList(evenNums));

        // Second, use stream forEach
        System.out.println("\n Stream forEach() to print");
        Arrays.stream(evenNums).forEach(n -> System.out.print(n + ", "));

        // Third, get iterator from Stream.
        System.out.println("\n\n Stream iterator() to print");
        Iterator it = Stream.of(evenNums).iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
    }
}
