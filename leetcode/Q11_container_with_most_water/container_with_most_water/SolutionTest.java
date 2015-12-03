/**
* @package container_with_most_water
* @author ZS@ZJU
* @version V1.0
*/
package container_with_most_water;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Nov 30, 2015 12:49:59 PM
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
        assertEquals(1,s.maxArea(new int[]{1,1}));
        assertEquals(12,s.maxArea(new int[]{1,3,2,5,10,9,2}));
        assertEquals(0,s.maxArea(new int[]{6}));
    }
}
