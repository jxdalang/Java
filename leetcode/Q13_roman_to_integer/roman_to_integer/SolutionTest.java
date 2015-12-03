/**
* @package roman_to_integer
* @author ZS@ZJU
* @version V1.0
*/
package roman_to_integer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Nov 30, 2015 1:10:58 PM
*/
public class SolutionTest {
    Solution s;

    /**
    * @description TODO
    * @throws java.lang.Exception 
    * @returnType void
    */
    @Before
    public void setUp() throws Exception {
        s = new Solution();
    }

    /**
    * @description TODO
    * @throws java.lang.Exception 
    * @returnType void
    */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        assertEquals(20,s.romanToInt("XX"));
        assertEquals(3015,s.romanToInt("MMMXV"));
        assertEquals(1444,s.romanToInt("MCDXLIV"));
    }

}
