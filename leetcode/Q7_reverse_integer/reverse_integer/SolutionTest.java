/**
* @package reverse_integer
* @author ZS@ZJU
* @version V1.0
*/
package reverse_integer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Nov 27, 2015 10:06:30 AM
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
        assertEquals(123, s.reverse(321));
        assertEquals(0, s.reverse(0));
        assertEquals(-2, s.reverse(-2));
        assertEquals(1, s.reverse(1));
        assertEquals(-238, s.reverse(-832));
        assertEquals(65, s.reverse(+56));
    }

}
