package pers.xiaoming.notebook.multithread;


import org.testng.annotations.Test;

public class AnnotationTest {

    @Test(threadPoolSize = 3, invocationCount = 10, timeOut = 1000)
    public void test() {
        System.out.println(Thread.currentThread().getId());
    }
}
