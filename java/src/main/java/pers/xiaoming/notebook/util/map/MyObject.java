package pers.xiaoming.notebook.util.map;

import java.util.Objects;

public class MyObject {
    private String name;
    private Integer id;

    public MyObject() {
    }

    public MyObject(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
