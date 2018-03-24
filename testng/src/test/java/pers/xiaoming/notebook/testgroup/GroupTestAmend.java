package pers.xiaoming.notebook.testgroup;

import org.testng.annotations.Test;

public class GroupTestAmend {
    @Test(groups = "func_test")
    public void func_step_3() {
        System.out.println("Running func test 3");
    }

    @Test(groups = "ignore_test")
    public void ignore_step_2() {
        System.out.println("Running ignore test 2");
    }
}
