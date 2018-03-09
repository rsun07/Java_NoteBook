package JavaBasicTest.InheritationTest;

public class Sub1 extends Super {
    public Sub1(String name) {
        // subclass has no access to super class's private fields
        super(name);
    }

    @Override
    void refresh() {

    }
}
