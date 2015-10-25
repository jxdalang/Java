package edu.zju.sc.zs;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

/**
 * This is a utility class that provides static methods for retrieving properties
 * of different types (String, Integer, Long, Double, Date, Class) from Properties instance.
 * This utility throws en exception specified by the caller if required property
 * is missing or cannot be parsed properly. getSubConfiguration() method
 * allows to extract inner configuration from Properties instance
 * (when "childConfigName.childPropertyName" format is used for property keys).
 *
 * Thread Safety:
 * This class is immutable and thread safe when properties parameters
 * passed to it are used by the caller in thread safe manner.
 *
 * @author ZS
 * @version 1.0
 */
public class PropertiesUtility {
    /**
     * Empty private constructor.
     */
    private PropertiesUtility() {
    }

    /**
     * Retrieves the string property from the given Properties instance.
     *
     * @throws T
     *             if the property is required, but missing
     * @param exceptionClass
     *            the type of the exception to be thrown if some error occurs
     * @param properties
     *            the properties container
     * @param key
     *            the key of the property to be retrieved
     * @param required
     *            true if property is required, false otherwise
     *            (if property is required, but missing, an exception is thrown)
     * @param <T>
     *            the type of the exception to be thrown if some error occurred
     * @return the retrieved string property value (null if property is optional and missing)
     */
    public static <T extends Throwable> String getStringProperty(Properties properties, String key, boolean required,
            Class<T> exceptionClass) throws T {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
            }
            return null;
        }
        return value;
    }

    /**
     * Retrieves the delimited strings property from the given Properties instance.
     *
     * @throws T
     *             if the property is required, but missing
     * @param delimiter
     *            the delimiter regular expression pattern
     * @param exceptionClass
     *            the type of the exception to be thrown if some error occurs
     * @param properties
     *            the properties container
     * @param key
     *            the key of the property to be retrieved
     * @param required
     *            true if property is required, false otherwise
     *            (if property is required, but missing, an exception is thrown)
     * @return the retrieved strings values (null if property is optional and missing)
     * @param <T>
     *            the type of the exception to be thrown if some error occurred
     */
    public static <T extends Throwable> String[] getStringsProperty(Properties properties, String key, String delimiter,
            boolean required, Class<T> exceptionClass) throws T {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
            }
            return null;
        }
        return value.split(delimiter, -1);
    }

    /**
     * Retrieves the integer property from the given Properties instance.
     *
     * @throws T
     *             if the property value has invalid format or is required, but missing
     * @param exceptionClass
     *            the type of the exception to be thrown if some error occurs
     * @param properties
     *            the properties container
     * @param key
     *            the key of the property to be retrieved
     * @param required
     *            true if property is required, false otherwise
     *            (if property is required, but missing, an exception is thrown)
     * @return the retrieved integer property value (null if property is optional and missing)
     * @param <T>
     *            the type of the exception to be thrown if some error occurred
     */
    public static <T extends Throwable> Integer getIntegerProperty(Properties properties, String key, boolean required,
            Class<T> exceptionClass) throws T {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
            }
            return null;
        }
        try {
            Integer result = Integer.valueOf(value);
            return result;
        } catch (NumberFormatException ex) {
            throw ExceptionHelper.constructException(exceptionClass,
                    getPropertyTitle(key) + " should be a valid integer", ex);
        }
    }

    /**
     * Retrieves the long integer property from the given Properties instance.
     *
     * @throws T
     *             if the property value has invalid format or is required, but missing
     * @param exceptionClass
     *            the type of the exception to be thrown if some error occurs
     * @param properties
     *            the properties container
     * @param key
     *            the key of the property to be retrieved
     * @param required
     *            true if property is required, false otherwise
     *            (if property is required, but missing, an exception is thrown)
     * @return the retrieved long integer property value (null if property is optional and missing)
     * @param <T>
     *            the type of the exception to be thrown if some error occurred
     */
    public static <T extends Throwable> Long getLongProperty(Properties properties, String key, boolean required,
            Class<T> exceptionClass) throws T {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
            }
            return null;
        }
        try {
            Long result = Long.valueOf(value);
            return result;
        } catch (NumberFormatException ex) {
            throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " should be a valid long",
                    ex);
        }
    }

    /**
     * Retrieves the double property from the given Properties instance.
     *
     * @throws T
     *             if the property value has invalid format or is required, but missing
     * @param exceptionClass
     *            the type of the exception to be thrown if some error occurs
     * @param properties
     *            the properties container
     * @param key
     *            the key of the property to be retrieved
     * @param required
     *            true if property is required, false otherwise
     *            (if property is required, but missing, an exception is thrown)
     * @return the retrieved double property value (null if property is optional and missing)
     * @param <T>
     *            the type of the exception to be thrown if some error occurred
     */
    public static <T extends Throwable> Double getDoubleProperty(Properties properties, String key, boolean required,
            Class<T> exceptionClass) throws T {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
            }
            return null;
        }
        try {
            Double result = Double.valueOf(value);
            return result;
        } catch (NumberFormatException ex) {
            throw ExceptionHelper.constructException(exceptionClass,
                    getPropertyTitle(key) + " should be a valid double");
        }
    }

    /**
     * Retrieves the date/time property from the given Properties instance.
     *
     * @throws T
     *             if the property value has invalid format or is required, but missing
     * @param exceptionClass
     *            the type of the exception to be thrown if some error occurs
     * @param properties
     *            the properties container
     * @param key
     *            the key of the property to be retrieved
     * @param required
     *            true if property is required, false otherwise
     *            (if property is required, but missing, an exception is thrown)
     * @return the retrieved date/time property value (null if property is optional and missing)
     * @param <T>
     *            the type of the exception to be thrown if some error occurred
     * @param format
     *            the expected date/time format string
     */
    public static <T extends Throwable> Date getDateProperty(Properties properties, String key, String format,
            boolean required, Class<T> exceptionClass) throws T {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
            }
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date result = new SimpleDateFormat(format, Locale.US).parse(value, parsePosition);
        if (result == null || parsePosition.getIndex() != value.length()) {
            throw ExceptionHelper.constructException(exceptionClass,
                    getPropertyTitle(key) + " should be in format [" + format + "]");
        }
        return result;
    }

    /**
     * Retrieves the class property from the given Properties instance.
     * Property value is expected to contain a full class name.
     *
     * @throws T
     *             if the property value has invalid format or is required, but missing
     * @param exceptionClass
     *            the type of the exception to be thrown if some error occurs
     * @param properties
     *            the properties container
     * @param key
     *            the key of the property to be retrieved
     * @param required
     *            true if property is required, false otherwise
     *            (if property is required, but missing, an exception is thrown)
     * @return the retrieved class property value (null if property is optional and missing)
     * @param <T>
     *            the type of the exception to be thrown if some error occurred
     */
    public static <T extends Throwable> Class<?> getClassProperty(Properties properties, String key, boolean required,
            Class<T> exceptionClass) throws T {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
            }
            return null;
        }
        try {
            Class<?> result = Class.forName(value);
            return result;
        } catch (ClassNotFoundException ex) {
            throw ExceptionHelper.constructException(exceptionClass,
                    getPropertyTitle(key) + " contains invalid full class name (" + value + ")", ex);
        }
    }

    /**
     * Retrieves the inner configuration from the configuration stored in Properties container.
     *
     * @param configName
     *            the name of the inner configuration
     * @param properties
     *            the properties with the main configuration
     * @return the Properties container with the extracted inner configuration (not null)
     */
    public static Properties getSubConfiguration(Properties properties, String configName) {
        String prefix = configName + ".";
        Properties result = new Properties();
        for (Object key : properties.keySet()) {
            if (key.getClass() == String.class) {
                String str = (String) key;
                if (str != null && str.startsWith(prefix)) {
                    result.put(str, properties.getProperty(str));
                }
            }
        }
        return result;
    }

    /**
     * Retrieves the property title to be used in exception message.
     *
     * @param key
     *            the property key
     * @return the constructed property title
     */
    private static String getPropertyTitle(String key) {
        return "The property '" + key + "'";
    }
}