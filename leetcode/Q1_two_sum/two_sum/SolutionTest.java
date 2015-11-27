/**
* @package two_sum
* @author ZS@ZJU
* @version V1.0
*/
package two_sum;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Nov 27, 2015 5:35:17 PM
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

        // test1
        int[] i1 = { 2, 7, 11, 15 };
        int[] o1 = { 1, 2 };
        int target1 = 9;
        assertTrue(Arrays.equals(s.twoSum(i1, target1), o1));

        // test2
        int[] i2 = { 3, 7, 11, 15, 18, -4, 5, 0, 22 };
        int[] o2 = { 6, 7 };
        int target2 = 1;
        assertTrue(Arrays.equals(s.twoSum(i2, target2), o2));

        // test3
        int[] i3 = { 7, 4 };
        int[] o3 = { 1, 2 };
        int target3 = 11;
        assertTrue(Arrays.equals(s.twoSum(i3, target3), o3));

        // test4
        int[] i4 = { -1, 0, 0, 4 };
        int[] o4 = { 1, 4 };
        int target4 = 3;
        assertTrue(Arrays.equals(s.twoSum(i4, target4), o4));
    }

}
