package basic.lang.inheritance;

import org.junit.Ignore;
import org.junit.Test;

public class BasicInheritTest {
    @Test
    @Ignore("Demo test, no assert")
    public void testConstructorInvokes() {
        new Sub();
    }

    @Test
    @Ignore("Demo test, no assert")
    public void testSubParamConstructor() {
        // Still invoke Super No parameter constructor
        // because Sub not specify super constructor
        new Sub(9);
    }

    @Test
    @Ignore("Demo test, no assert")
    public void testSubParamConstructorSpecifySuperConstructor() {
        new Sub("str");
    }

    @Test
    @Ignore("Demo test, no assert")
    public void testSubThisConstructor() {
        new SubConstructorThis(8);
    }
}
