package edu.zju.sc.zs;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className TestValidationUtility
* @description test class ValidationUtility
* @author ZS@ZJU
* @date Oct 25, 2015 7:07:09 PM
*/
public class TestValidationUtility {
    private IllegalArgumentException exception = new IllegalArgumentException(
            "test exception");
    private String value = "my value";
    private String name = "my parameter";
    private String myFile = "src/test/java/edu/zju/sc/zs/TestValidationUtility.java";
    private String myDir = "src";
    private Collection<String> collection = new ArrayList<String>();
    private Map<String, String> map = new HashMap<String, String>();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    /**
     * test successful cases
     */
    public void testSuccessful() {
        value = null;
        ValidationUtility.checkNotNull(1, name, exception.getClass());
        ValidationUtility.checkNotEmpty("test", name, exception.getClass());
        ValidationUtility.checkNotEmpty(value, name, exception.getClass());
        ValidationUtility.checkNotEmptyAfterTrimming("test   ", name,
                exception.getClass());
        ValidationUtility.checkNotEmptyAfterTrimming(value, name,
                exception.getClass());
        ValidationUtility.checkNotNullNorEmpty("test", name,
                exception.getClass());
        ValidationUtility.checkNotNullNorEmptyAfterTrimming("test   ", name,
                exception.getClass());
        ValidationUtility.checkInstance("test", String.class, name,
                exception.getClass());
        ValidationUtility.checkNullOrInstance("test", String.class, name,
                exception.getClass());
        ValidationUtility.checkNullOrInstance(null, String.class, name,
                exception.getClass());
        ValidationUtility.checkExists(new File(myFile), name,
                exception.getClass());
        ValidationUtility.checkExists(new File(myDir), name,
                exception.getClass());
        ValidationUtility.checkIsFile(new File(myFile), name,
                exception.getClass());
        ValidationUtility.checkIsDirectory(new File(myDir), name,
                exception.getClass());

        collection = new ArrayList<String>();
        collection.add("1");
        ValidationUtility.checkNotEmpty(collection, name, exception.getClass());
        collection = null;
        ValidationUtility.checkNotEmpty(collection, name, exception.getClass());
        collection = new ArrayList<String>();
        collection.add("1");
        ValidationUtility.checkNotNullNorEmpty(collection, name,
                exception.getClass());
        collection = new ArrayList<String>();

        map = new HashMap<String, String>();
        map.put("1", "1");
        ValidationUtility.checkNotEmpty(map, name, exception.getClass());
        map = null;
        ValidationUtility.checkNotEmpty(map, name, exception.getClass());
        map = new HashMap<String, String>();
        map.put("1", "1");
        ValidationUtility.checkNotNullNorEmpty(map, name, exception.getClass());

        // checkNotEmptyElements
        collection = new ArrayList<String>();
        collection.add("   ");
        ValidationUtility.checkNotEmptyElements(collection, false, name,
                exception.getClass());
        collection.clear();
        collection.add("1   ");
        ValidationUtility.checkNotEmptyElements(collection, true, name,
                exception.getClass());
        collection.clear();
        ValidationUtility.checkNotEmptyElements(collection, false, name,
                exception.getClass());
        collection.add("1");
        Collection<Collection<String>> collection2 = new ArrayList<Collection<String>>();
        collection2.add(collection);
        ValidationUtility.checkNotEmptyElements(collection2, false, name,
                exception.getClass());

        map.clear();
        map.put("3", "2");
        Collection<Map<String, String>> collectionMap = new ArrayList<Map<String, String>>();
        collectionMap.add(map);
        ValidationUtility.checkNotEmptyElements(collectionMap, true, name,
                exception.getClass());

        collectionMap = null;
        ValidationUtility.checkNotEmptyElements(collectionMap, true, name,
                exception.getClass());

        Collection<Integer> collection3 = new ArrayList<Integer>();
        collection3.add(1);
        ValidationUtility.checkNotEmptyElements(collection3, true, name,
                exception.getClass());

        // checkNotNullElements
        collectionMap = null;
        ValidationUtility.checkNotNullElements(collectionMap, name,
                exception.getClass());

        collection = new ArrayList<String>();
        collection.add("   ");
        ValidationUtility.checkNotNullElements(collection, name,
                exception.getClass());

        // checkNotNullKeys
        map = null;
        ValidationUtility.checkNotNullKeys(map, name, exception.getClass());

        map = new HashMap<String, String>();
        map.put("3", "2");
        ValidationUtility.checkNotNullKeys(map, name, exception.getClass());

        // checkNotNullValues
        map = null;
        ValidationUtility.checkNotNullValues(map, name, exception.getClass());

        map = new HashMap<String, String>();
        map.put("3", "2");
        ValidationUtility.checkNotNullValues(map, name, exception.getClass());

        // checkNotEmptyKeys
        map = new HashMap<String, String>();
        map.put("   ", "asasdf");
        ValidationUtility.checkNotEmptyKeys(map, false, name,
                exception.getClass());
        map.clear();
        map.put("1   ", "asdfc");
        ValidationUtility.checkNotEmptyKeys(map, true, name,
                exception.getClass());
        map.clear();
        ValidationUtility.checkNotEmptyKeys(map, false, name,
                exception.getClass());

        collection = new ArrayList<String>();
        collection.add("   ");
        map.put("1", "asdfasf");
        Map<Collection<String>, String> map2 = new HashMap<Collection<String>, String>();
        map2.put(collection, "123sa");
        ValidationUtility.checkNotEmptyKeys(map2, false, name,
                exception.getClass());

        map.clear();
        map.put("3", "2");
        Map<Map<String, String>, String> map3 = new HashMap<Map<String, String>, String>();
        map3.put(map, "asc3");
        ValidationUtility.checkNotEmptyKeys(map3, true, name,
                exception.getClass());

        map3 = null;
        ValidationUtility.checkNotEmptyKeys(map3, true, name,
                exception.getClass());

        Map<Integer, String> map4 = new HashMap<Integer, String>();
        map4.put(1, "asdf");
        ValidationUtility.checkNotEmptyKeys(map4, true, name,
                exception.getClass());

        // checkNotEmptyValues
        map = new HashMap<String, String>();
        map.put("asasdf", "   ");
        ValidationUtility.checkNotEmptyValues(map, false, name,
                exception.getClass());
        map.clear();
        map.put("asdfc", "1   ");
        ValidationUtility.checkNotEmptyValues(map, true, name,
                exception.getClass());
        map.clear();
        ValidationUtility.checkNotEmptyValues(map, false, name,
                exception.getClass());

        collection = new ArrayList<String>();
        collection.add("   ");
        map.put("asdfasf", "1");
        Map<String, Collection<String>> map5 = new HashMap<String, Collection<String>>();
        map5.put("123sa", collection);
        ValidationUtility.checkNotEmptyValues(map5, false, name,
                exception.getClass());

        map.clear();
        map.put("3", "2");
        Map<String, Map<String, String>> map6 = new HashMap<String, Map<String, String>>();
        map6.put("asc3", map);
        ValidationUtility.checkNotEmptyValues(map6, true, name,
                exception.getClass());

        map6 = null;
        ValidationUtility.checkNotEmptyValues(map6, true, name,
                exception.getClass());

        Map<Integer, Integer> map7 = new HashMap<Integer, Integer>();
        map7.put(1, 3);
        ValidationUtility.checkNotEmptyValues(map7, true, name,
                exception.getClass());

        // #check double
        ValidationUtility.checkGreaterThan(9.0, 6.1, false, name,
                exception.getClass());
        ValidationUtility.checkGreaterThan(9.0, 9.0, true, name,
                exception.getClass());

        ValidationUtility.checkLessThan(3.1, 6.1, false, name,
                exception.getClass());
        ValidationUtility.checkLessThan(9.0, 9.0, true, name,
                exception.getClass());

        ValidationUtility.checkNegative(-1.3, name, exception.getClass());
        ValidationUtility.checkPositive(2.9, name, exception.getClass());
        ValidationUtility.checkNotNegative(1.2, name, exception.getClass());
        ValidationUtility.checkNotPositive(-1.234, name, exception.getClass());
        ValidationUtility.checkNotNegative(0.0, name, exception.getClass());
        ValidationUtility.checkNotPositive(0.0, name, exception.getClass());
        ValidationUtility.checkNotZero(0.001, name, exception.getClass());

        ValidationUtility.checkInRange(1.3, 1.1, 1.5, false, false, name,
                exception.getClass());
        ValidationUtility.checkInRange(1.1, 1.1, 1.5, true, false, name,
                exception.getClass());
        ValidationUtility.checkInRange(1.5, 1.1, 1.5, false, true, name,
                exception.getClass());
        ValidationUtility.checkInRange(1.5, 1.5, 1.5, true, true, name,
                exception.getClass());

        // #check long
        ValidationUtility.checkGreaterThan(9, 6, false, name,
                exception.getClass());
        ValidationUtility.checkGreaterThan(9, 9, true, name,
                exception.getClass());

        ValidationUtility
                .checkLessThan(3, 6, false, name, exception.getClass());
        ValidationUtility.checkLessThan(9, 9, true, name, exception.getClass());

        ValidationUtility.checkNegative(-1, name, exception.getClass());
        ValidationUtility.checkPositive(2, name, exception.getClass());
        ValidationUtility.checkNotNegative(1, name, exception.getClass());
        ValidationUtility.checkNotPositive(-1, name, exception.getClass());
        ValidationUtility.checkNotNegative(0, name, exception.getClass());
        ValidationUtility.checkNotPositive(0, name, exception.getClass());
        ValidationUtility.checkNotZero(2, name, exception.getClass());

        ValidationUtility.checkInRange(3, 1, 5, false, false, name,
                exception.getClass());
        ValidationUtility.checkInRange(1, 1, 5, true, false, name,
                exception.getClass());
        ValidationUtility.checkInRange(5, 1, 5, false, true, name,
                exception.getClass());
        ValidationUtility.checkInRange(5, 5, 5, true, true, name,
                exception.getClass());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNull() {
        value = null;
        ValidationUtility.checkNotNull(value, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmpty1() {
        value = "";
        ValidationUtility.checkNotEmpty(value, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyAfterTrimming1() {
        value = "    ";
        ValidationUtility.checkNotEmptyAfterTrimming(value, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmpty1() {
        value = null;
        ValidationUtility.checkNotNullNorEmpty(value, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmpty2() {
        value = "";
        ValidationUtility.checkNotNullNorEmpty(value, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmptyAfterTrimming1() {
        value = null;
        ValidationUtility.checkNotNullNorEmptyAfterTrimming(value, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmptyAfterTrimming2() {
        value = "    ";
        ValidationUtility.checkNotNullNorEmptyAfterTrimming(value, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckInstance1() {
        ValidationUtility.checkInstance(1, String.class, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckInstance2() {
        ValidationUtility.checkInstance(null, String.class, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNullOrInstance1() {
        ValidationUtility.checkNullOrInstance(1, String.class, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckExists1() {
        ValidationUtility.checkExists(new File("asfasdfsafasf"), name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIsFile1() {
        ValidationUtility.checkIsFile(new File(myDir), name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIsDirectory1() {
        ValidationUtility.checkIsDirectory(new File(myFile), name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyCollection1() {
        collection.clear();
        ValidationUtility.checkNotEmpty(collection, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmptyCollection1() {
        collection.clear();
        ValidationUtility.checkNotNullNorEmpty(collection, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmptyCollection2() {
        collection = null;
        ValidationUtility.checkNotNullNorEmpty(collection, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyMap1() {
        map.clear();
        ValidationUtility.checkNotEmpty(map, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmptyMap1() {
        map.clear();
        ValidationUtility.checkNotNullNorEmpty(map, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmptyMap2() {
        map = null;
        ValidationUtility.checkNotNullNorEmpty(map, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyElements1() {
        collection = new ArrayList<String>();
        collection.add("");
        ValidationUtility.checkNotEmptyElements(collection, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyElements2() {
        collection = new ArrayList<String>();
        collection.add("   ");
        ValidationUtility.checkNotEmptyElements(collection, true, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyElements3() {
        collection.clear();
        Collection<Collection<String>> collection2 = new ArrayList<Collection<String>>();
        collection2.add(collection);
        ValidationUtility.checkNotEmptyElements(collection2, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyElements4() {
        map.clear();
        Collection<Map<String, String>> collection2 = new ArrayList<Map<String, String>>();
        collection2.add(map);
        ValidationUtility.checkNotEmptyElements(collection2, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullElements1() {
        collection = new ArrayList<String>();
        collection.add(null);
        ValidationUtility.checkNotNullElements(collection, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullKeys1() {
        map = new HashMap<String, String>();
        map.put(null, "asdf");
        ValidationUtility.checkNotNullKeys(map, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullValues1() {
        map = new HashMap<String, String>();
        map.put("asdf", null);
        ValidationUtility.checkNotNullValues(map, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyKeys1() {
        map = new HashMap<String, String>();
        map.put("", "asc2a");
        ValidationUtility.checkNotEmptyKeys(map, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyKeys2() {
        map = new HashMap<String, String>();
        map.put("   ", "cawef");
        ValidationUtility.checkNotEmptyKeys(map, true, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyKeys3() {
        collection.clear();
        Map<Collection<String>, String> map2 = new HashMap<Collection<String>, String>();
        map2.put(collection, "casaf2");
        ValidationUtility.checkNotEmptyKeys(map2, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyKeys4() {
        map.clear();
        Map<Map<String, String>, String> map2 = new HashMap<Map<String, String>, String>();
        map2.put(map, "casdf");
        ValidationUtility.checkNotEmptyKeys(map2, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyValues1() {
        map = new HashMap<String, String>();
        map.put("asc2a", "");
        ValidationUtility.checkNotEmptyValues(map, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyValues2() {
        map = new HashMap<String, String>();
        map.put("cawef", "   ");
        ValidationUtility.checkNotEmptyValues(map, true, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyValues3() {
        collection.clear();
        Map<String, Collection<String>> map2 = new HashMap<String, Collection<String>>();
        map2.put("casaf2", collection);
        ValidationUtility.checkNotEmptyValues(map2, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyValues4() {
        map.clear();
        Map<String, Map<String, String>> map2 = new HashMap<String, Map<String, String>>();
        map2.put("casdf", map);
        ValidationUtility.checkNotEmptyValues(map2, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckGreaterThan1() {
        ValidationUtility.checkGreaterThan(9.0, 9.0, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckGreaterThan2() {
        ValidationUtility.checkGreaterThan(6.3, 9.0, true, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLessThan1() {
        ValidationUtility.checkLessThan(9.0, 9.0, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLessThan2() {
        ValidationUtility.checkLessThan(9.02, 9.0, true, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNegative1() {
        ValidationUtility.checkNegative(0.0, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNegative2() {
        ValidationUtility.checkNegative(0.134, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckPositive1() {
        ValidationUtility.checkPositive(0.0, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckPositive2() {
        ValidationUtility.checkPositive(-2.23, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotZero1() {
        ValidationUtility.checkNotZero(0.0, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNegative1() {
        ValidationUtility.checkNotNegative(-1.1, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotPositive1() {
        ValidationUtility.checkNotPositive(1.3, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckInRange1() {
        ValidationUtility.checkInRange(1.5, 1.5, 1.5, false, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckInRange2() {
        ValidationUtility.checkInRange(1.1, 1.3, 1.5, true, true, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckInRange3() {
        ValidationUtility.checkInRange(1.6, 1.3, 1.5, true, true, name,
                exception.getClass());
    }

    // check long
    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongGreaterThan1() {
        ValidationUtility.checkGreaterThan(9, 9, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongGreaterThan2() {
        ValidationUtility.checkGreaterThan(6, 9, true, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongLessThan1() {
        ValidationUtility
                .checkLessThan(9, 9, false, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongLessThan2() {
        ValidationUtility
                .checkLessThan(10, 9, true, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongNegative1() {
        ValidationUtility.checkNegative(0, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongNegative2() {
        ValidationUtility.checkNegative(12, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongPositive1() {
        ValidationUtility.checkPositive(0, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongPositive2() {
        ValidationUtility.checkPositive(-2, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongNotZero1() {
        ValidationUtility.checkNotZero(0, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongNotNegative1() {
        ValidationUtility.checkNotNegative(-1, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongNotPositive1() {
        ValidationUtility.checkNotPositive(1, name, exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongInRange1() {
        ValidationUtility.checkInRange(5, 5, 5, false, false, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongInRange2() {
        ValidationUtility.checkInRange(1, 3, 5, true, true, name,
                exception.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLongInRange3() {
        ValidationUtility.checkInRange(6, 3, 5, true, true, name,
                exception.getClass());
    }

}