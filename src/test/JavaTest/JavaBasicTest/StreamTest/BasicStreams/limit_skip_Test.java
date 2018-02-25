package JavaTest.JavaBasicTest.StreamTest.BasicStreams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class limit_skip_Test {

    /*
        Although the Stream only execute once at when it get a terminal operation
        And Stream is just like a collection of functions.
        But, the order of each function DO have big impact on the result
     */
    @Test
    public void limitAndSkipTest() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

        List<Integer> result1 =
                list.stream().skip(3).limit(3).skip(2).collect(Collectors.toList());
        System.out.println(result1);

        List<Integer> result2 =
                list.stream().skip(1).limit(3).skip(2).collect(Collectors.toList());
        System.out.println(result2);

        List<Integer> result3 =
                list.stream().skip(5).limit(3).collect(Collectors.toList());
        System.out.println(result3);
    }
}
