package pers.xiaoming.notebook.lang.enum_;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

public class ExtensibleOperatorTest {

    @Test
    public void testExtendedOperation() {
        double x = 6.6;
        double y = 8.8;
        test(ExtendedOperation.class, x, y);
        test(BaseOperation.class, x, y);
    }

    //bounded type token 
    private static <T extends Enum<T> & Operation> void test (
            Class<T> opEnumType, double x, double y) {
        // enum_ is loaded into memory similar to static filed / parameter.
        // because you can get the enum_ constants from the class rather than an instance / object
        // even before static field from the book <effective java 3>
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%.3f %s %.3f = %.4f%n",
                    x, op, y, op.apply(x, y));

        }
    }

    @Test
    public void testExtendedOperation2() {
        double x = 6.6;
        double y = 8.8;
        test(Arrays.asList(ExtendedOperation.values()), x, y);
//        test(BaseOperation.class, x, y);
    }

    // bounded wildcard type 
    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%.3f %s %.3f = %.4f%n",
                    x, op, y, op.apply(x, y));

        }
    }
}
