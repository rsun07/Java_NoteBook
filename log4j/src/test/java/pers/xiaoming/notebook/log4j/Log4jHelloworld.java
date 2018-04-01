package pers.xiaoming.notebook.log4j;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.apache.log4j.Logger;
import pers.xiaoming.notebook.utils.PathUtils;

public class Log4jHelloworld {

    private static Logger logger = Logger.getLogger(Log4jHelloworld.class);

    @Test
    public void testXml() {
        DOMConfigurator.configure(PathUtils.LOG4J_TEST_RESOURCE_DIR + "/log4j/helloworld.xml");
        logger.debug("Hello world Log4j XML");
    }

    @Test
    public void testProperties() {
        PropertyConfigurator.configure(PathUtils.LOG4J_TEST_RESOURCE_DIR + "/log4j/helloworld.properties");
        logger.debug("Hello world Log4j Properties");
    }
}
