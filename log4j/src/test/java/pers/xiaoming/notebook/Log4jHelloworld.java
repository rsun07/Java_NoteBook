package pers.xiaoming.notebook;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.apache.log4j.Logger;
import pers.xiaoming.notebook.utils.PathUtils;

public class Log4jHelloworld {
    @Test
    public void test() {
        Logger logger = Logger.getLogger(Log4jHelloworld.class);

        DOMConfigurator.configure(PathUtils.XML_DIR + "/helloworld.xml");
        logger.debug("Hello world Log4j");
    }
}
