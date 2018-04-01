package pers.xiaoming.notebook.slf4j;


import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    @Test
    public void test() {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class.getName());
        BasicConfigurator.configure();
        logger.info("Hello World For slf4j");
    }
}
