package pers.xiaoming.notebook.depend;


import org.testng.annotations.Test;

public class DependTest {
    @Test(dependsOnGroups = "func_test")
    public void ignore_step_1() {
        System.out.println("Running ignore test 1");
    }

    @Test(dependsOnMethods = "func_step_1", groups = "func_test")
    public void func_step_2() {
        System.out.println("Running func test 2");
    }

    @Test(groups = "func_test")
    public void func_step_1() {
        System.out.println("Running func test 1");
    }
}
