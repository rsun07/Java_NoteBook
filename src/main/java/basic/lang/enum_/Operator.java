package basic.lang.enum_;


// Enum type with constant-specific class bodies and data
enum Operator {
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

    Operator(String symbol) { this.symbol = symbol; }

    @Override public String toString() { return symbol; }

    // abstract method to force each enum_ type implement its own method.
    public abstract double apply(double x, double y);
}