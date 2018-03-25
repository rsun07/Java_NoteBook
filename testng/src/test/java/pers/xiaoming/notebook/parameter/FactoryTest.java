package pers.xiaoming.notebook.parameter;

import org.testng.annotations.Test;

public class FactoryTest {

    private String name;
    private Long createdAt;

    public FactoryTest(String name, Long createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "FactoryTest{" +
                "name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Test
    public void test() {
        System.out.println(this.toString());
    }

    @Test
    public void test2() {
        this.name = this.name + "2";
        System.out.println(this.toString());
    }
}
