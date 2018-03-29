package pers.xiaoming.notebook.basic.lang.inheritance;

class Sub extends Super {
    Sub() {
        // In sub class, there is a hidden super constructor
        // super();
        System.out.println("Sub No Parameter Constructor called");
    }

    Sub(int i) {
        // This will still call the empty parameter constructor of Super class
        // super();
        System.out.println("Sub int Parameter Constructor called");
    }

    Sub(String str) {
        // If specify the super constructor,
        // it will stop visit Super's non-parameter constructor
        super(str);
        System.out.println("Sub String Parameter Constructor called");
    }
}
