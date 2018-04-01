package pers.xiaoming.notebook.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {
    @Test
    public void testDebug() {
        new DebugLogging().log("debug log");
    }
}
