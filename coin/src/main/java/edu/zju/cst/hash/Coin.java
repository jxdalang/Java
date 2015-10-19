package edu.zju.cst.hash;

import java.util.HashMap;

/**
 * @author KUMA 
 * @description coin value-name map
 */
public class Coin {
	// fields
	private HashMap<Integer, String> coin = new HashMap<Integer, String>();

	// constructor
	public Coin() {
		coin.put(1, "penny");
		coin.put(10, "dime");
		coin.put(25, "quarter");
		coin.put(50, "half-dollar");
	}

	// methods
	/**
	 * @param amount
	 *            value of the coin
	 * @return name of the coin
	 */
	public String getName(int amount) {
		if (coin.containsKey(amount))
			return coin.get(amount);
		else
			return "NOT FOUND";
	}

	/**
	 * @return number of maps
	 */
	public int showSetNum() {
		// keySet()获取键值的集合
		return coin.keySet().size();
	}

	/**
	 * @return object content in string form
	 */
	public String getString() {
		return coin.toString();
	}

}