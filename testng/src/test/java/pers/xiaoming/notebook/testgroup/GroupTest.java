package pers.xiaoming.notebook.testgroup;


import org.testng.annotations.Test;

public class GroupTest {
    @Test(groups = "func_test")
    public void func_step_1() {
        System.out.println("Running func test 1");
    }

    @Test(groups = {"func_test", "check_in_test"})
    public void func_step_2() {
        System.out.println("Running func test 2 and check in test 1");
    }

    @Test(groups = "ignore_test")
    public void ignore_step_1() {
        System.out.println("Running ignore test 1");
    }
}
