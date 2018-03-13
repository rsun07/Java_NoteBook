package JavaBasicTest.EnumClass;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testOperation() {

        double x = 6.6;
        double y = 8.8;
        for (Operation op : Operation.values()) {
            System.out.printf("%.2f %s %.2f = %.3f%n", x, op, y, op.apply(x, y));
        }
    }


    // Enum type with constant-specific class bodies and data
    enum Operation {
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

        Operation(String symbol) { this.symbol = symbol; }

        @Override public String toString() { return symbol; }

        // abstract method to force each enum type implement its own method.
        public abstract double apply(double x, double y);
    }
}

