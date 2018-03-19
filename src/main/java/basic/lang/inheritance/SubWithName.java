package basic.lang.inheritance;

class SubWithName extends SuperWithName {
    int num = 888;
    String name = "Sub";

    SubWithName() {
        // in fact, super() constructor will be called here
        //super();
        System.out.println("Sub constructor : num = " + num);
        show();
    }

    @Override
    void show() {
        System.out.println(this.name + "  show Super number:  " + num);
    }

    @Override
    void showSuper() {
        System.out.println(super.name + "  show Super in Sub Class, number:  " + super.num);
    }
}
