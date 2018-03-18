package basic.lang.KeyWords;

public class InheritInPolymorphic {
    public static void main(String args[]) {

        // member variable refers to Father class
        Fu f = new Zi();
        System.out.println(f.num);

        // the f in stack still point to the 'new Zi()' address in the heap
        // So it will call Zi's function
        f.show();

        // same as member variable
        // go to the method part in memory
        f.showStatic();
    }
}

class Fu {
    int num = 0;

    void show() {
        System.out.println(" Fu Show");
    }

    static void showStatic() {
        System.out.println("static Fu Show");
    }
}

class Zi extends Fu {
    int num = 1;

    void show() {
        System.out.println(" Zi Show");
    }

    static void showStatic() {
        System.out.println("static Zi Show");
    }
}
