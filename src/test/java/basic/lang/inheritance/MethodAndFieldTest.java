package basic.lang.inheritance;

import org.junit.Ignore;
import org.junit.Test;

public class MethodAndFieldTest {
    @Test
    @Ignore("Demo test, no assert")
    public void testConstructorWithField() {
        new SubWithName();
    }

    @Test
    @Ignore("Demo test, no assert")
    public void testFunctionInherit() {
        new SubFunction().function();
    }
}
