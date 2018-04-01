package pers.xiaoming.notebook.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugLogging implements Logging {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public void log(String msg) {
           logger.debug(msg);
    }
}
