package basic.lang.InheritationTest;

import lombok.Getter;

public abstract class Super {
    @Getter
    private static String className;

    @Getter
    static String sharedName;

    public Super(String name) {
        className = name;
        System.out.println("Super Constructor called");
        refresh();
    }

    abstract void refresh();
}
