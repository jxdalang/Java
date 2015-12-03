/**
* @package palindrome_number
* @author ZS@ZJU
* @version V1.0
*/
package palindrome_number;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Nov 28, 2015 4:45:46 PM
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
        
        //test isPalindrome()
        assertEquals(true, s.isPalindrome(12321));
        assertEquals(true, s.isPalindrome(123321));
        assertEquals(false, s.isPalindrome(-1));
        assertEquals(true, s.isPalindrome(0));
        assertEquals(false, s.isPalindrome(01210));
        
        // test isPalindrome_integer()
        assertEquals(true, s.isPalindrome_integer(12321));
        assertEquals(true, s.isPalindrome_integer(123321));
        assertEquals(false, s.isPalindrome_integer(-1));
        assertEquals(true, s.isPalindrome_integer(0));
        assertEquals(false, s.isPalindrome_integer(01210));
    }

}
