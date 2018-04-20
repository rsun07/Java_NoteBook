package pers.xiaoming.notebook.lang.polymorphic;

class Sub extends Super {
    int num = 1;

    void show() {
        System.out.println("Sub Show");
    }

    static void showStatic() {
        System.out.println("static Sub Show");
    }
}
