package pers.xiaoming.notebook.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import pers.xiaoming.notebook.utils.Slf4jLoggerInitializer;

public class HelloWorld {
    @Test
    public void test() {
        Logger logger = Slf4jLoggerInitializer.getInstance();
        logger.info("Hello World For slf4j");
    }
}
