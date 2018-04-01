package pers.xiaoming.notebook.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pers.xiaoming.notebook.utils.PathUtils;

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
        PropertyConfigurator.configure(PathUtils.LOG4J_TEST_RESOURCE_DIR + "/level.properties");
    }

    @Test
    public void testDebug() {
        Assert.assertFalse(logger.isDebugEnabled());
        if (logger.isDebugEnabled()) {
            logger.debug("debug");
        }
    }

    @Test
    public void testInfo() {
        Assert.assertFalse(logger.isInfoEnabled());
        if (logger.isInfoEnabled()) {
            logger.info("info");
        }
    }

    @Test
    public void testWarn() {
        // logger.isWarnEnabled() method not exist
        Assert.assertTrue(logger.isEnabledFor(Level.WARN));
        if (logger.isEnabledFor(Level.WARN)) {
            logger.warn("warn");
        }
    }

    @Test
    public void testError() {
        Assert.assertTrue(logger.isEnabledFor(Level.ERROR));
        if (logger.isEnabledFor(Level.ERROR)) {
            logger.error("error");
        }
    }

    @Test
    public void testFatal() {
        Assert.assertTrue(logger.isEnabledFor(Level.FATAL));
        if (logger.isEnabledFor(Level.FATAL)) {
            logger.fatal("fatal");
        }
    }
}
