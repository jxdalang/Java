package edu.zju.sc.zs;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className TestLoggingUtilityHelper
* @description test class LoggingUtilityHelper
* @author ZS@ZJU
* @date Oct 25, 2015 6:26:16 PM
*/
public class TestLoggingUtilityHelper {
    private String signature;
    private String[] paramNames;
    private Object[] paramValues;
    private Object value;
    private Exception exception;

    @Before
    public void setUp() {
        signature = "test_method";
        paramNames = new String[] { "param1", "param2" };
        paramValues = new String[] { "value1", "value2" };
        value = "outValue";
        exception = new Exception("Test Exception");
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetMethodEntranceMessage() {
        assertEquals("Entering method [test_method].",
                LoggingUtilityHelper.getMethodEntranceMessage(signature));
    }

    @Test
    public void testGetInputParametersMessage() {
        assertEquals("Input parameters [param1:value1, param2:value2]",
                LoggingUtilityHelper.getInputParametersMessage(paramNames,
                        paramValues));
    }


    @Test
    public void testGetMethodExitMessage1() {
        assertEquals("Exiting method [test_method].",
                LoggingUtilityHelper.getMethodExitMessage(signature, null));
    }

    @Test
    public void testGetMethodExitMessage2() {
        String result = LoggingUtilityHelper.getMethodExitMessage(signature,
                new Date());
        assertTrue(result
                .startsWith("Exiting method [test_method], time spent in the method: "));
    }

    @Test
    public void testOutputValueMessage() {
        assertEquals("Output parameter: outValue",
                LoggingUtilityHelper.getOutputValueMessage(value));
    }

    @Test
    public void testGetExceptionMessage() {
        String result = LoggingUtilityHelper.getExceptionMessage(signature,
                exception);
        assertTrue(result
                .startsWith("Error in method [test_method], details: "));
    }

}
