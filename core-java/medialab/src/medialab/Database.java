/**
* @package medialab
* @author ZS@ZJU
* @version V1.0
*/
package medialab;

import java.util.ArrayList;

/**
* @className Database
* @description Store items
* @author ZS@ZJU
* @date Oct 1, 2015 4:01:57 PM
*/
public class Database {
	private ArrayList<Item> itemList = new ArrayList<>();

	/**
	* @description default constructor
	*/
	public Database() {
		super();
	}

	public void add(Item item) {
		itemList.add(item);
	}

	public Item getItem(int index) {

		return itemList.get(index - 1);
	}

	public void list() {
		for (Item i : itemList) {
			i.print();
		}
	}

	// test method
	public static void main(String args[]) {
		Database db = new Database();
		db.add(new CD("Higher(M-MIX)", 129, "2015", "加藤ミリヤ", 5));
		db.add(new CD("あなたに爱たくて", 276, "2013", "AZU", 8));
		db.add(new DVD("Jurassic.World", 204, "science fiction", "unknown"));

		db.getItem(2).setGotIt(true);

		db.list();

	}

}
