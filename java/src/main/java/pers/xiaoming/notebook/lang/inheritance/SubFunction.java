package pers.xiaoming.notebook.lang.inheritance;

class SubFunction extends SuperFunction {
    @Override
    void print() {
        System.out.println("Children's print function");
    }

    @Override
    void function() {
        super.function();
    }
}
