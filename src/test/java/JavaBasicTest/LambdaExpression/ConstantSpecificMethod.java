package java.JavaBasicTest.LambdaExpression;

import java.util.function.DoubleBinaryOperator;

public class ConstantSpecificMethod {


    // Enum type with constant-specific class bodies and data
    enum Operation {
        // this won't override the abstract method
        //        PLUS("+") { (x, y) -> (x + y);},

        PLUS    ("+", (x,y) -> (x+y)),
        MINUS   ("-", (x,y) -> (x-y)),
        TIMES   ("*", (x,y) -> (x*y)),
        DIVIDE  ("/", (x,y) -> (x/y)),

        //method reference
        PLUS2   ("+",   Double::sum);

        private final String symbol;
        private final DoubleBinaryOperator op;

        Operation(String symbol, DoubleBinaryOperator op) {
            this.symbol = symbol;
            this.op = op;
        }

        @Override public String toString() { return symbol; }

        public double apply (double x, double y) {
            return op.applyAsDouble(x, y);
        }
    }
}
