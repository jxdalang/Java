package hash.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.*;

import hash.Coin;

/**
 * @author KUMA 
 * Ê¾·¶µÄ²âÊÔÀà
 * Failure--²âÊÔÊ§°Ü
 * Error==²âÊÔ³ÌĞòÓĞ´íÎó
 * ÒªÅÅ³ıError²ÅÄÜ¿¼ÂÇFailure
 */
public class CoinTest {

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
