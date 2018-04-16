package pers.xiaoming.notebook.basic.lang.condition;

import org.junit.Ignore;
import org.junit.Test;

public class ElseIfTest {

    @Test
    @Ignore("Demo test, no assert")
    public void testIfTrue() {

        // 1. if is executing

        int i = 8;

        if (i > 0) {
            System.out.println("1. if is executing");
        } else if (i > 1) {
            System.out.println("2. else if is executing");
        } else if (i > 2) {
            System.out.println("3. else if is executing");
        } else if (i < 2) {
            System.out.println("4. else if is NOT executing");
        } else {
            System.out.println("5. else is executing");
        }
    }

    @Test
    @Ignore("Demo test, no assert")
    public void testIfFalse() {

        // 2. else if is executing
        int i = 8;

        if (i < 0) {
            System.out.println("1. if is executing");
        } else if (i > 1) {
            System.out.println("2. else if is executing");
        } else if (i > 2) {
            System.out.println("3. else if is executing");
        } else if (i < 2) {
            System.out.println("4. else if is NOT executing");
        } else {
            System.out.println("5. else is executing");
        }
    }
}
