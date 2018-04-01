package pers.xiaoming.notebook;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Test
    public void test() {
        System.out.println(logger.getClass());
        Assert.assertTrue(logger instanceof org.slf4j.impl.SimpleLogger);
        logger.info("Hello World For slf4j default");
    }
}
