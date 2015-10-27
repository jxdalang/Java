package hash.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.*;

import hash.Coin;

/**
* @className TestCoin
* @description 测试Coin类
* Failure--测试不通过
* Error--程序有错
* 要先解决Error才能考虑Failure
* @author ZS@ZJU
* @date Sep 29, 2015 10:57:30 PM
*/
public class TestCoin {

    Coin c;

    @Before
    public void setUp() throws Exception {
        c = new Coin();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetName() {
        assertEquals("!!Wrong Match!!", "quarter", c.getName(25));
        // fail("Not yet implemented");
    }

    @Test
    public void testShowSetNum() {
        assertThat(c.showSetNum(), is(4));
        // fail("Not yet implemented");
    }

    // @Ignore
    @Test
    public void testList() {
        assertThat(c.getString(), allOf(containsString("50=half-dollar"), containsString("25=quarter")));
        // fail("Not yet implemented");
    }

}
