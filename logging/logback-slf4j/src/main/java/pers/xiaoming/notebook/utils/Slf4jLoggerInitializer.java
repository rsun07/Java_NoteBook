package pers.xiaoming.notebook.utils;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLoggerInitializer {
    private static Logger LOGGER;

    private Slf4jLoggerInitializer() {
    }

    public static Logger getInstance() {
        if (LOGGER == null) {
            synchronized (Slf4jLoggerInitializer.class) {
                LOGGER = LoggerFactory.getLogger("SLF4J");
                BasicConfigurator.configure();
            }
        }
        return LOGGER;
    }
}
