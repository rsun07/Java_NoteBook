package pers.xiaoming.notebook.lang.polymorphic;

import org.junit.Ignore;
import org.junit.Test;

public class PolymorphicTest {
    @Test
    @Ignore("Demo test, no assert")
    @SuppressWarnings("static-access")
    public void testBasicPloymorphic() {
        Super object = new Sub();
        object.show();
        object.showStatic();
    }
}
