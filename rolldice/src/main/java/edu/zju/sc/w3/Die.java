package edu.zju.sc.w3;

import java.util.Random;

/**
 * @className Die
 * @description models a n-sided die
 * @author ZS@ZJU
 * @date Sep 29, 2015
 * 
 */
public class Die {
	private int sides = 6;
	private int topface = 1;

	/**
	 * @description construct a default die with 6 sides
	 */
	public Die() {

	}

	/**
	 * @description construct a die with sides given
	 * @param sides
	 *            specify the number of sides
	 */
	public Die(int sides) {
		if (sides <= 0)
			this.sides = 6;
		else
			this.sides = sides;
	}

	/**
	* @description get the number of sides
	* @return the number of sides
	* @returnType int
	*/
	public int numOfSides() {
		return sides;
	}

	/**
	* @description roll the die
	* @return the value on top surface of the die after rolling it
	* @returnType int
	*/
	public int roll() {
		Random r = new Random(System.currentTimeMillis());
		topface = r.nextInt(sides) + 1;
		return topface;
	}

	/**
	* @description get top surface
	* @return the value on the top surface of the die without rolling it
	* @returnType int
	*/
	public int topFace() {
		return topface;
	}

}
