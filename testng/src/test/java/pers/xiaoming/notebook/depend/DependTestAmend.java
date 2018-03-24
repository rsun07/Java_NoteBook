package pers.xiaoming.notebook.depend;

import org.testng.annotations.Test;

@Test(groups = "func_test")
public class DependTestAmend {
    @Test(dependsOnMethods = "pers.xiaoming.notebook.depend.DependTest.func_step_2")
    public void func_step_3() {
        System.out.println("Running func test 3");
    }
}
