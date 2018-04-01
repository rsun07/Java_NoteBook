package pers.xiaoming.notebook.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorLogging implements Logging {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void log(String msg) {
        logger.error(msg);
    }
}
