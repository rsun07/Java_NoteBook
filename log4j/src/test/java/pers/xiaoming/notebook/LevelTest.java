package pers.xiaoming.notebook;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import pers.xiaoming.notebook.utils.PathUtils;

import java.util.Map;
import java.util.Properties;

public class LevelTest {
    private static Logger logger = Logger.getLogger(Log4jHelloworld.class);

    // ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
    // The properties file setting, log level is WARN
    // only WARN, ERROR, FATAL will output
    // ALL, DEBUG and INFO won't be output


    /*
        Output:
            2018-03-31 22:47:50 ERROR Log4jHelloworld:40 - error
            2018-03-31 22:47:50 FATAL Log4jHelloworld:45 - fatal
            2018-03-31 22:47:50 WARN  Log4jHelloworld:35 - warn


     */
    @BeforeClass
    public static void setup() {
        PropertyConfigurator.configure(PathUtils.TEST_RESOURCE_DIR  + "/level.properties");
    }

    @Test
    public void testDebug() {
        logger.debug("debug");
    }

    @Test
    public void testInfo() {
        logger.info("info");
    }

    @Test
    public void testWarn() {
        logger.warn("warn");
    }

    @Test
    public void testError() {
        logger.error("error");
    }

    @Test
    public void testFatal() {
        logger.fatal("fatal");
    }
}
