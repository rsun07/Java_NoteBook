package basic.lang.Primitive;

import org.junit.Test;

public class PrimitiveAutoBoxingTest {

    @Test
    public void slowBecauseLong() {
        // 7.587 s
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            // every time, there is a new Long Object created
            sum += i;
        }
        System.out.println(sum);
    }

    @Test
    public void fasterBecause_long() {
        // 799 ms
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

}
