/**
* @package string_to_Integer
* @author ZS@ZJU
* @version V1.0
*/
package string_to_Integer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Nov 27, 2015 11:12:39 AM
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
        //test myAtoi()
        assertEquals(0, s.myAtoi(""));
        assertEquals(0, s.myAtoi("+"));
        assertEquals(123, s.myAtoi("123"));
        assertEquals(-123, s.myAtoi("---123"));
        assertEquals(-123, s.myAtoi("  -123+"));
        assertEquals(123, s.myAtoi(" a df-+-123 sad"));
        assertEquals(-123, s.myAtoi("-n +vd%!+-++123 sa d"));
        
        //test myAtoi_limited_convert()
        assertEquals(0, s.myAtoi_limited_convert(""));
        assertEquals(0, s.myAtoi_limited_convert("+"));
        assertEquals(123, s.myAtoi_limited_convert("123"));
        assertEquals(0, s.myAtoi_limited_convert("---123"));
        assertEquals(-123, s.myAtoi_limited_convert("  -123+"));
        assertEquals(0, s.myAtoi_limited_convert(" a df-+-123 sad"));
        assertEquals(0, s.myAtoi_limited_convert("-n +vd%!+-++123 sa d"));
    }

}
