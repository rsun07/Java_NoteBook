package pers.xiaoming.notebook.basic.lang.enum_;

import java.util.HashSet;
import java.util.Set;

enum EnumWithStatic {

    ONE("one"),
    TWO("two"),
    THREE("three");

    private String name;

    EnumWithStatic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static final Set<String> names;

    // Enum construction is earlier than static block
    static {
        names = new HashSet<>();
        for (EnumWithStatic numEnum : EnumWithStatic.values()) {
            names.add(numEnum.getName());
        }
    }

    public static boolean contains(String name) {
        return names.contains(name);
    }
}
