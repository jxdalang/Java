package edu.zju.sc.w3;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.*;

/**
* @className TestDie
* @description test the class "Die"
* @author ZS@ZJU
* @date Sep 29, 2015
* 
*/
public class TestDie {

	Die d1;
	Die d2;
	Die d3;
	Die d4;

	/**
	* @description create test objects
	* @returnType void
	*/
	@Before
	public void setUp() {
		d1 = new Die();
		d2 = new Die(8);
		d3 = new Die(16);
		d4 = new Die(-2);
	}

	/**
	 * Test method for {@link edu.zju.sc.w3.Die#numOfSides()}.
	 */
	@Test
	public void testNumOfSides() {
		assertThat(d1.numOfSides(), is(6));
		assertThat(d2.numOfSides(), is(8));
		assertThat(d3.numOfSides(), is(16));
		assertThat(d4.numOfSides(), is(6));
	}

	/**
	 * Test method for {@link edu.zju.sc.w3.Die#roll()}.
	 */
	@Test
	public void testRoll() {
		for (int i = 0; i < 10; i++) {
			assertThat(d1.roll(), anyOf(is(1), is(2), is(3), is(4), is(5), is(6)));
		}
		for (int i = 0; i < 10; i++) {
			assertThat(d2.roll(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(8)));
		}
		for (int i = 0; i < 10; i++) {
			assertThat(d3.roll(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(16)));
		}
	}

	/**
	 * Test method for {@link edu.zju.sc.w3.Die#topFace()}.
	 */
	@Test
	public void testTopFace() {
		d1.roll();
		d2.roll();
		d3.roll();
		assertThat(d1.topFace(), anyOf(is(1), is(2), is(3), is(4), is(5), is(6)));
		assertThat(d2.topFace(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(8)));
		assertThat(d3.topFace(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(16)));
	}

}
