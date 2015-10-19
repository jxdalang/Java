/**
* @package castle
* @author ZS@ZJU
* @version V1.0
*/
package castle;

/**
* @className HandlerGo
* @description handle command go
* @author ZS@ZJU
* @date Oct 2, 2015 5:00:09 PM
*/
public class HandlerGo extends Handler {

	public HandlerGo(Game game) {
		super(game);
	}

	@Override
	public void doCmd(String args) {
		game.goRoom(args);
	}
	

}
