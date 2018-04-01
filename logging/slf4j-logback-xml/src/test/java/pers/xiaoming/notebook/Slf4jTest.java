package pers.xiaoming.notebook;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Ignore("Demo test, only print to console")
public class Slf4jTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Test
    public void testDebug() {
        logger.debug("Debug test for slf4j");
    }

    @Test
    public void testError() {
        logger.error("Error test for slf4j");
    }

    @Test
    public void testInfo() {
        logger.info("Info test for slf4j");
    }
}
