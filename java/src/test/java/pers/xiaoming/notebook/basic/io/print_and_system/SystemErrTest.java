package pers.xiaoming.notebook.basic.io.print_and_system;

import org.junit.Test;

public class SystemErrTest {

    @Test
    public void test() {
        try {
            Integer.valueOf("abc");
        } catch (Exception e) {
            // red color
            System.err.println(e.getMessage());
            // normal color
            System.out.println(e.getMessage());
        }
    }
}
