package pers.xiaoming.notebook.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.utils.PathUtils;

public class FileAppenderTest {
    private static Logger logger = Logger.getLogger(Log4jHelloworld.class);
    @BeforeClass
    public static void setup() {
        PropertyConfigurator.configure(PathUtils.LOG4J_TEST_RESOURCE_DIR + "/log4j/fileappender.properties");
    }

    @Ignore("Demo test")
    @Test
    public void test() {
        logger.debug("debug log");
    }
}
