package edu.zju.sc.zs;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className TestLog4jUtility
* @description test class Log4jUtility
* @author ZS@ZJU
* @date Oct 25, 2015 6:56:29 PM
*/
public class TestLog4jUtility {
    private Logger logger;

    @Before
    public void setUp() throws Exception {
        logger = Logger.getLogger(getClass());
        PatternLayout myLayout = new PatternLayout();
        FileAppender fileAppender = new FileAppender(myLayout,
                "testing log(Log4jUtility only).txt");
        logger.addAppender(fileAppender);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test() {
        logger.info("Begin Log Test1");
        String signature = "myTestMethod";
        Date entranceTimestamp = new Date();
        Log4jUtility.logEntrance(logger, signature, new String[] { "param1",
                "param2" }, new String[] { "value1", "value2" });
        Log4jUtility.logEntrance(logger, signature, new String[] { "param1",
                "param2" }, new String[] { "value1", "value2" }, Level.INFO);

        int result = 0;
        for (int i = 1; i < 1000; i++) {
            result += i;
        }
        Log4jUtility.logExit(logger, signature, new Object[] { result });
        Log4jUtility.logExit(logger, signature, new Object[] { result },
                entranceTimestamp);
        Log4jUtility.logExit(logger, signature, new Object[] { result },
                entranceTimestamp, Level.INFO);
        Log4jUtility.logException(logger, "test_method", new Exception(
                "Test Exception"));
        Log4jUtility.logException(logger, "test_method", new Exception(
                "Test Exception"), Level.FATAL);
        logger.info("Finish Log Test1");
        logger.info("--------------------------------------");

        logger.info("Begin Log Test2(no parameter)");
        Log4jUtility.logEntrance(logger, signature, null, null);
        Log4jUtility.logEntrance(logger, signature, null, null, Level.INFO);
        Log4jUtility.logExit(logger, signature, null);
        Log4jUtility.logExit(logger, signature, null, entranceTimestamp);
        Log4jUtility.logExit(logger, signature, null, entranceTimestamp,
                Level.INFO);
        logger.info("Finish Log Test2");
        logger.info("--------------------------------------");

        logger.info("Begin Log Test3(logger = null)");
        Log4jUtility.logEntrance(null, signature, null, null);
        Log4jUtility.logEntrance(null, signature, null, null, Level.INFO);
        Log4jUtility.logExit(null, signature, null);
        Log4jUtility.logExit(null, signature, null, entranceTimestamp);
        Log4jUtility.logExit(null, signature, null, entranceTimestamp,
                Level.INFO);
        Log4jUtility.logException(null, "test_method", new Exception(
                "Test Exception"));
        Log4jUtility.logException(null, "test_method", new Exception(
                "Test Exception"), Level.FATAL);
        logger.info("Finish Log Test3");

    }

}
