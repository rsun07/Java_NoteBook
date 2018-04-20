package pers.xiaoming.notebook.lang.inheritance;

class SubConstructorThis extends Super {
    SubConstructorThis() {
        System.out.println("Sub No Parameter Constructor called");
    }

    SubConstructorThis(int i) {
        this();
        System.out.println("Sub this() Constructor called");
    }
}
