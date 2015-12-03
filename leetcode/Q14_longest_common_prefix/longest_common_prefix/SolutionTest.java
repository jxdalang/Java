/**
* @package longest_common_prefix
* @author ZS@ZJU
* @version V1.0
*/
package longest_common_prefix;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Nov 30, 2015 1:52:11 PM
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
        s= new Solution();
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
        assertEquals("",s.longestCommonPrefix(new String[]{""}));
        assertEquals("",s.longestCommonPrefix(new String[]{}));
        assertEquals("",s.longestCommonPrefix(new String[]{"","prefix"}));
        assertEquals("pre",s.longestCommonPrefix(new String[]{"prefix","pretend","predict","prepare"}));
    }

}
