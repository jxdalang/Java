package edu.zju.sc.zs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className TestExceptionHelper
* @description test class ExceptionHelper
* @author ZS@ZJU
* @date Oct 25, 2015 5:04:51 PM
*/
public class TestExceptionHelper {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    /**
     * This is the test for constructing an exception without cause.
     */
    public void test1() {
        Throwable exception = ExceptionHelper.constructException(
                NullPointerException.class, "Pointer is null!");
        assertEquals("Pointer is null!", exception.getMessage());
    }

    @Test
    /**
     * This is the test for constructing an exception with cause.
     */
    public void test2() {
        Throwable baseException = new NullPointerException("Pointer is null!");
        Throwable exception = ExceptionHelper.constructException(
                IllegalArgumentException.class, "Argument is illegal!",
                baseException);
        assertEquals("Argument is illegal!", exception.getMessage());
        assertEquals("Pointer is null!", exception.getCause().getMessage());
    }

}

