/**
* @package castle
* @author ZS@ZJU
* @version V1.0
*/
package castle;

/**
* @className Handler
* @description superclass of all handlers
* @author ZS@ZJU
* @date Oct 2, 2015 4:55:26 PM
*/
public abstract class Handler {
	protected Game game;

	public Handler(Game game) {
		super();
		this.game = game;
	}

	public abstract void doCmd(String args);
	
	public boolean isBye() {
		return false;
	}

}
