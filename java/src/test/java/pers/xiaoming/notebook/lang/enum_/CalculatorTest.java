package pers.xiaoming.notebook.lang.enum_;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testOperation() {

        double x = 6.6;
        double y = 8.8;
        for (Operator op : Operator.values()) {
            System.out.printf("%.2f %s %.2f = %.3f%n", x, op, y, op.apply(x, y));
        }
    }
}

