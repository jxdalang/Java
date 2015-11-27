/**
* @package zigzag_conversion
* @author ZS@ZJU
* @version V1.0
*/
package zigzag_conversion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @className SolutionTest
* @description TODO
* @author ZS@ZJU
* @date Nov 27, 2015 12:38:10 AM
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
        assertEquals("PAYPALISHIRING", s.convert("PAYPALISHIRING", 1));
        assertEquals("PYAIHRNAPLSIIG", s.convert("PAYPALISHIRING", 2));
        assertEquals("PAHNAPLSIIGYIR", s.convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", s.convert("PAYPALISHIRING", 4));
        assertEquals("PHASIYIRPLIGAN", s.convert("PAYPALISHIRING", 5));
        assertEquals("PRAIIYHNPSGAIL", s.convert("PAYPALISHIRING", 6));
    }

}
