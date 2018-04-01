package pers.xiaoming.notebook.slf4j;

import org.junit.Test;

public class Slf4jTest {
    @Test
    public void testDebug() {
        new DebugLogging().log("debug log");
    }
}
