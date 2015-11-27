/**
* @package longest_substring_without_repeating_characters
* @author ZS@ZJU
* @version V1.0
*/
package longest_substring_without_repeating_characters;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Nov 27, 2015 6:12:06 PM
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
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, s.lengthOfLongestSubstring("bbb"));
        assertEquals(1, s.lengthOfLongestSubstring("a"));
        assertEquals(3, s.lengthOfLongestSubstring("dvdx"));
        assertEquals(2, s.lengthOfLongestSubstring("addv"));
        assertEquals(3, s.lengthOfLongestSubstring("abccca"));
    }

}
