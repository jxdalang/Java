package castle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
	private Room currentRoom;
	private HashMap<String, Handler> handlers = new HashMap<>();

	public Game() {
		// 添加支持的命令
		handlers.put("go", new HandlerGo(this));
		handlers.put("bye", new HandlerBye(this));
		handlers.put("help", new HandlerHelp(this));

		// 创建地图
		createRooms();
	}

	public void play() {
		Scanner in = new Scanner(System.in);

		// 主循环
		printWelcome();
		while (true) {
			String line = in.nextLine();
			String[] cmd = line.split(" ");
			Handler handler = handlers.get(cmd[0]);
			String args = null;
			if (cmd.length > 1)
				args = cmd[1];
			if (handler != null) {
				handler.doCmd(args);
				if (handler.isBye())
					break;
			}
		}

		in.close();
	}

	private void createRooms() {

		// 制造房间
		Room outside = new Room("城堡外");
		Room lobby = new Room("大堂");
		Room pub = new Room("小酒吧");
		Room celler = new Room("地窖");
		Room study = new Room("书房");
		Room bedroom = new Room("卧室");

		// 初始化房间的出口
		outside.setExit("east", lobby);
		outside.setExit("south", study);
		outside.setExit("west", pub);
		lobby.setExit("west", outside);
		pub.setExit("east", outside);
		pub.setExit("down", celler);
		celler.setExit("up", pub);
		study.setExit("east", bedroom);
		study.setExit("north", outside);
		bedroom.setExit("west", study);

		// 设定初始位置
		currentRoom = outside;
	}

	private void showPrompt() {
		System.out.println("你在" + currentRoom);
		System.out.print("出口有：");
		System.out.println(currentRoom.getExitInfo());
	}

	private void printWelcome() {
		System.out.println();
		System.out.println("欢迎来到城堡！");
		System.out.println("这是一个超级无聊的游戏。");
		System.out.println("如果需要帮助，请输入 'help' 。");
		System.out.println();
		showPrompt();
	}

	// 以下为用户命令

	public void goRoom(String direction) {
		Room nextRoom = currentRoom.moveToExit(direction);

		if (nextRoom == null) {
			System.out.println("那里没有门！");
		} else {
			currentRoom = nextRoom;
			showPrompt();
		}
	}

	// 运行游戏
	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}

}
