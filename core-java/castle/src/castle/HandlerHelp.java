/**
* @package castle
* @author ZS@ZJU
* @version V1.0
*/
package castle;

/**
* @className HandlerHelp
* @description handle command help
* @author ZS@ZJU
* @date Oct 2, 2015 5:24:02 PM
*/
public class HandlerHelp extends Handler {

	public HandlerHelp(Game game) {
		super(game);
	}

	public void doCmd(String args) {
		System.out.println("迷路了吗？你可以做的命令有：go bye help");
		System.out.println("例如：go east");
	}

}
