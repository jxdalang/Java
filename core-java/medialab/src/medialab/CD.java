/**
* @package medialab
* @author ZS@ZJU
* @version V1.0
*/
package medialab;

/**
* @className CD
* @description CD media type
* @author ZS@ZJU
* @date Oct 1, 2015 4:00:17 PM
*/
public class CD extends Item {
	private String artist;
	private int numOfTracks;

	public CD(String title, int playTime, String comment, String artist, int numOfTracks) {
		super(title, playTime, comment);
		this.artist = artist;
		this.numOfTracks = numOfTracks;
	}

	/* (non-Javadoc)
	* description print CD info
	* @see medialab.Item#print()
	*/
	public void print() {
		System.out.println("\n  CD INFO  ");
		System.out.println("----------------------");
		super.print();
		System.out.println("Artist: " + artist);
		System.out.println("Number of tracks: " + numOfTracks);
		System.out.println("----------------------");
	}
}
