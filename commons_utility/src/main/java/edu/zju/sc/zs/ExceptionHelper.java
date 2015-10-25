package edu.zju.sc.zs;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * This is a static helper class that provides methods for
 * constructing exception instances using reflection.
 * It is used by ValidationUtility, PropertiesUtility and JDBCUtility.
 *
 * Thread Safety:
 * This class is immutable and thread safe when array parameters
 * passed to it are used by the caller in thread safe manner.
 *
 * @author ZS
 * @version 1.0
*/
class ExceptionHelper {
    /**
     * Empty private constructor.
     */
    private ExceptionHelper() {
    }

    /**
     * Constructs an exception of the specified type with the given message.
     *
     * @param exceptionClass
     *            the exception class
     * @param <T>
     *            the type of the exception to be created
     * @param message
     *            the message
     * @return the constructed exception instance (not null)
     */
    static <T extends Throwable> T constructException(Class<T> exceptionClass, String message) {
        Constructor<T> constructor;
        try {
            constructor = exceptionClass.getConstructor(String.class);
            T result = constructor.newInstance(message);
            return result;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Constructs an exception of the specified type with the given message and cause.
     *
     * @param exceptionClass
     *            the exception class
     * @param <T>
     *            the type of the exception to be created
     * @param cause
     *            the exception cause
     * @param message
     *            the message
     * @return the constructed exception instance (not null)
     */
    static <T extends Throwable> T constructException(Class<T> exceptionClass, String message, Throwable cause) {
        try {
            Constructor<T> constructor = exceptionClass.getConstructor(String.class, Throwable.class);
            T result = constructor.newInstance(message, cause);
            return result;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}