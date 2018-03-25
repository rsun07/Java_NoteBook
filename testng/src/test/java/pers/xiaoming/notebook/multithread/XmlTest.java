package pers.xiaoming.notebook.multithread;


import org.testng.annotations.Test;

public class XmlTest {
    @Test(groups = "test")
    public void test() {
        System.out.println(Thread.currentThread().getId());
    }
}
