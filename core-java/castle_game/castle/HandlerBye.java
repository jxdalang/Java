/**
* @package castle
* @author ZS@ZJU
* @version V1.0
*/
package castle;

/**
* @className HandlerBye
* @description handle command bye
* @author ZS@ZJU
* @date Oct 2, 2015 5:24:28 PM
*/
public class HandlerBye extends Handler {

	public HandlerBye(Game game) {
		super(game);
	}

	@Override
	public void doCmd(String args) {
		System.out.println("感谢您的光临。再见！");
	}

	@Override
	public boolean isBye() {
		return true;
	}

}
