package java8.lambda.customized_functional_interface;

// define a functional interface by myself
// functional interface can only has one single method
// but it can override the method that inherit from Object,
// for example, toString(), hashCode();
// it can have static methods and default methods
@FunctionalInterface
interface MyFunctionalInterface {
    // target method
    // the only method allowed in functional interface
    String myMethod(Integer i, Double d, String s);

    // static methods
    static void print() {
        System.out.println("The static print method in MyFunctionalInterface triggered!");
    }

    static void print(String s) {
        System.out.println("The static print method in MyFunctionalInterface triggered!"
                + "Your input String is: " + s);
    }

    // it is called outside, but in fact,
    // it shouldn't appear inside the interface
    // it's not good
    static String combineThree(Integer i, Double d, String s) {
        return String.format("%d %s %.3f = %s",i, s, d,  i + s + d);
    }

    default String combineThreeDefault(Integer i, Double d, String s) {
        return String.format("Combine Three : %d %s %.4f = %s",i, s, d,  i + s + d);
    }

    // default and static cannot be used at the same time
//        default static String combineThreeStaticDefault(Integer i, Double d, String s) {
//            return String.format("Combine Three : %d %s %.4f = %s",i, s, d,  i + s + d);
//        }

    default void printLine() {
        System.out.println("The default printLine method in MyFunctionalInterface triggered!");
    }

    default void printLine(String s) {
        System.out.println("The default printLine method in MyFunctionalInterface triggered!"
                + "Your input String is: " + s);
    }
}
