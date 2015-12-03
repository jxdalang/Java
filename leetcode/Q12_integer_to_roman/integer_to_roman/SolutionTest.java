/**
* @package integer_to_roman
* @author ZS@ZJU
* @version V1.0
*/
package integer_to_roman;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Nov 30, 2015 12:40:04 PM
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
        assertEquals("XX", s.intToRoman(20));
        assertEquals("MMMXV", s.intToRoman(3015));
        assertEquals("MCDXLIV", s.intToRoman(1444));
    }

}
