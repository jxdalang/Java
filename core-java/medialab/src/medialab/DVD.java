/**
* @package medialab
* @author ZS@ZJU
* @version V1.0
*/
package medialab;

/**
* @className DVD
* @description DVD medi type
* @author ZS@ZJU
* @date Oct 1, 2015 4:01:16 PM
*/
public class DVD extends Item {
	private String director;

	public DVD(String title, int playTime, String comment, String director) {
		super(title, playTime, comment);
		this.director = director;
	}

	/* (non-Javadoc)
	* description print DVD info
	* @see medialab.Item#print()
	*/
	public void print() {
		System.out.println("\n DVD INFO  ");
		System.out.println("----------------------");
		super.print();
		System.out.println("Director: " + director);
		System.out.println("----------------------");
	}
}
