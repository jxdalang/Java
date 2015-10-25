package edu.zju.sc.zs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className TestPropertiesUtility
* @description test class PropertiesUtility
* @author ZS@ZJU
* @date Oct 25, 2015 7:15:58 PM
*/
public class TestPropertiesUtility {
    private Properties properties = new Properties();
    private IllegalArgumentException exception = new IllegalArgumentException(
            "test exception");
    String format = "yyyy-MM-dd";
    String dateValue = "2015-10-25";
    String dateKey = "today";
    String stringValue = "ZS";
    String stringKey = "name";
    String stringsKey = "numbers";
    String delimiter = ",";
    String stringsValue = "1,2,3";
    String intKey = "age";
    int intValue = 11;
    String longKey = "length";
    long longValue = 100L;
    String doubleKey = "temperature";
    double doubleValue = 20.8;
    String classKey = "class";
    String classValue = "java.lang.Object";
    String wrongClassKey = "wrongClass";
    String wrongClassValue = "acasfasdf";
    String configName = "child";
    String childKey = "child.name";
    String childValue = "Alice";

    @Before
    public void setUp() throws Exception {
        properties.put(dateKey, dateValue);
        properties.put(stringKey, stringValue);
        properties.put(stringsKey, stringsValue);
        properties.put(intKey, String.valueOf(intValue));
        properties.put(longKey, String.valueOf(longValue));
        properties.put(doubleKey, String.valueOf(doubleValue));
        properties.put(classKey, classValue);
        properties.put(wrongClassKey, wrongClassValue);
        properties.put(childKey, childValue);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    /**
     * test successful cases
     */
    public void testSuccessful() {
        // getDateProperty
        Date resultDate = PropertiesUtility.getDateProperty(properties,
                dateKey, format, true, exception.getClass());
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        assertEquals(dateValue, dateFormat.format(resultDate));

        assertEquals(null, PropertiesUtility.getDateProperty(properties,
                "yesterday", "", false, exception.getClass()));

        // getStringProperty
        assertEquals(stringValue, PropertiesUtility.getStringProperty(
                properties, stringKey, true, exception.getClass()));
        assertEquals(null, PropertiesUtility.getStringProperty(properties,
                "address", false, exception.getClass()));

        // getStringsValue
        assertTrue(Arrays.equals(stringsValue.split(delimiter),
                PropertiesUtility.getStringsProperty(properties, stringsKey,
                        delimiter, true, exception.getClass())));
        assertTrue(Arrays.equals(null, PropertiesUtility.getStringsProperty(
                properties, "asdfcad", delimiter, false, exception.getClass())));

        // getIntegerProperty
        assertTrue(intValue == PropertiesUtility.getIntegerProperty(properties,
                intKey, true, exception.getClass()));
        assertEquals(null, PropertiesUtility.getIntegerProperty(properties,
                "address", false, exception.getClass()));

        // getLongProperty
        assertTrue(longValue == PropertiesUtility.getLongProperty(properties,
                longKey, true, exception.getClass()));
        assertEquals(null, PropertiesUtility.getLongProperty(properties,
                "address", false, exception.getClass()));

        // getDoubleProperty
        assertTrue(Double.compare(doubleValue, PropertiesUtility
                .getDoubleProperty(properties, doubleKey, true,
                        exception.getClass())) == 0);
        assertEquals(null, PropertiesUtility.getDoubleProperty(properties,
                "address", false, exception.getClass()));

        // getClassProperty
        assertTrue(classValue.equals(PropertiesUtility.getClassProperty(
                properties, classKey, true, exception.getClass()).getName()));
        assertEquals(null, PropertiesUtility.getClassProperty(properties,
                "address", false, exception.getClass()));

        // getSubConfiguration
        Properties childProperties = PropertiesUtility.getSubConfiguration(
                properties, configName);
        Set<Object> childKeySet = childProperties.keySet();
        Set<Object> checkSet = new HashSet<Object>();
        checkSet.add(childKey);
        assertTrue(checkSet.equals(childKeySet));
        assertTrue(childProperties.getProperty(childKey).equals(childValue));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDateProperty1() {
        PropertiesUtility.getDateProperty(properties, "yesterday", "", true,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDateProperty2() {
        PropertiesUtility.getDateProperty(properties, dateKey, "yyyy:MM:dd",
                true, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetStringProperty1() {
        PropertiesUtility.getStringProperty(properties, "address", true,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetStringsProperty1() {
        PropertiesUtility.getStringsProperty(properties, "asdfcad", delimiter,
                true, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIntegerProperty1() {
        PropertiesUtility.getIntegerProperty(properties, "address", true,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLongProperty1() {
        PropertiesUtility.getLongProperty(properties, "address", true,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDoubleProperty1() {
        PropertiesUtility.getDoubleProperty(properties, "address", true,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetClassProperty1() {
        PropertiesUtility.getClassProperty(properties, "address", true,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetClassProperty2() {
        PropertiesUtility.getClassProperty(properties, wrongClassKey, true,
                exception.getClass());
    }
}