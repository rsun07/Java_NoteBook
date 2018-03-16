package JavaBasicTest.lang.EnumClass;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

public class ExtensibleOperatorTest {

    interface Operation {
        double apply(double x, double y);
    }

    // Enum type with constant-specific class bodies and data
    enum BaseOperation implements Operation {
        PLUS("+") {
            public double apply(double x, double y) { return x + y; }
        },
        MINUS("-") {
            public double apply(double x, double y) { return x - y; }
        },
        TIMES("*") {
            public double apply(double x, double y) { return x * y; }
        },
        DIVIDE("/") {
            public double apply(double x, double y) { return x / y; }
        };

        private final String symbol;

        BaseOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override public String toString() {
            return symbol;
        }
    }

    enum ExtendedOperation implements Operation {
        EXP("^") {
            public double apply(double x, double y) {
                return Math.pow(x, y);
            }
        },
        REMAINDER("%") {
            public double apply(double x, double y) {
                return x % y;
            }
        };

        private final String symbol;

        ExtendedOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override public String toString() {
            return symbol;
        }
    }


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
        // enum is loaded into memory similar to static filed / parameter.
        // because you can get the enum constants from the class rather than an instance / object
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
