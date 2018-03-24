package pers.xiaoming.notebook.testgroup;

import org.testng.annotations.Test;

@Test(groups = "func_test")
public class GroupTestAmend {
    public void func_step_3() {
        System.out.println("Running func test 3");
    }

    @Test(groups = "ignore_test")
    public void ignore_step_2() {
        System.out.println("Running ignore test 2");
    }

    // test ignored, whatever the "ignore_test" put first or later
    @Test(groups = {"ignore_test", "func_test"})
    public void func_step_4() {
        System.out.println("Running func test 4 and ignore test 3");
    }
}
