/**
* @package valid_parentheses
* @author ZS@ZJU
* @version V1.0
*/
package valid_parentheses;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Dec 1, 2015 11:15:13 AM
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
        assertTrue(s.isValid("(()){}[]"));
        assertTrue(s.isValid("()[]{}"));
        assertTrue(s.isValid("{}"));
        assertFalse(s.isValid("(}"));
        assertFalse(s.isValid("]"));
        assertFalse(s.isValid("{"));
    }

}
