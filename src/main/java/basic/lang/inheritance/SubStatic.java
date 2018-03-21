package basic.lang.inheritance;

class SubStatic extends SuperStatic {
    static String staticStr = "SubStatic";

    SubStatic() {
        showStaticSub();
        print();
    }

    void showStaticSub() {
        System.out.println("Sub show sub static String : " + staticStr);
        System.out.println("Sub show super static String : " + super.staticStr);
    }

    // Cannot override static method
    // @Override
    static void print() {
        System.out.println("Sub static method.");
    }

    public static void staticOnlyInSub() {
        System.out.println("Sub only static method.");
    }
}
