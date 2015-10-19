package castle;

import java.util.HashMap;

public class Room {
	private String description;
	private HashMap<String, Room> exits = new HashMap<>();

	public Room(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}

	public void setExit(String direction, Room room) {
		exits.put(direction, room);
	}

	/**
	* @description get all exits
	* @return exits in String
	* @returnType String
	*/
	public String getExitInfo() {
		// 如果用String类型每次加上一段字符会导致系统开销很大
		// 因此这里用StringBuffer
		StringBuffer ret = new StringBuffer();

		for (String direction : exits.keySet())
			ret.append(direction + " ");

		return ret.toString();
	}

	/**
	* @description go to another room with direction
	* @param direction
	* @return another room
	* @returnType Room
	*/
	public Room moveToExit(String direction) {
		return exits.get(direction);
	}

}
