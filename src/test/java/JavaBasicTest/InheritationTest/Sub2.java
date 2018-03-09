package JavaBasicTest.InheritationTest;

import java.util.HashMap;
import java.util.Map;

public class Sub2 extends Super {
    private Map<String, String> map = new HashMap<>();

    public Sub2(String name) {
        super(name);
        sharedName = name + "shared";
        refresh();
    }

    @Override
    void refresh() {
        System.out.println("MAP is null? " + String.valueOf(map == null));
    }
}
