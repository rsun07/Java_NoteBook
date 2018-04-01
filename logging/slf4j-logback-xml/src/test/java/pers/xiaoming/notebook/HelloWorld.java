package pers.xiaoming.notebook;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Test
    public void test() {
        Assert.assertTrue(logger instanceof ch.qos.logback.classic.Logger);
        logger.info("Hello World For slf4j logback");
    }
}
