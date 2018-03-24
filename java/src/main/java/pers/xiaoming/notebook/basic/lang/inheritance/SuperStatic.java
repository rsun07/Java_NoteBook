package basic.lang.inheritance;

class SuperStatic {
    static String staticStr = "SuperStatic";

    SuperStatic() {
        showStatic();
        print();
    }

    void showStatic() {
        System.out.println("Super static String : " + staticStr);
        System.out.println("Super 'this' static String : " + this.staticStr);
    }

    static void print() {
        System.out.println("Super static method.");
    }
}
