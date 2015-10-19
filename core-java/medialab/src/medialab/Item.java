/**
* @package medialab
* @author ZS@ZJU
* @version V1.0
*/
package medialab;

/**
* @className Item
* @description superclass of various media type
* @author ZS@ZJU
* @date Oct 1, 2015 3:59:40 PM
*/
public abstract class Item {
	private String title;
	private int playTime;
	private boolean gotIt;
	private String comment;

	public Item(String title, int playTime, String comment) {
		super();
		this.title = title;
		this.playTime = playTime;
		this.gotIt = false;
		this.comment = comment;
	}

	public void setGotIt(boolean gotIt) {
		this.gotIt = gotIt;
	}

	/**
	* @description print item info 
	* @returnType void
	*/
	public void print() {
		System.out.println("Title: " + title);
		System.out.println("Possession: " + gotIt);
		System.out.println("Playtime: " + playTime);
		System.out.println("comment: " + comment);
	}

}
