package clock;

public class Clock {
	private Display hour;
	private Display minute;
	private Display second;

	// constructor
	public Clock(int hour, int minute, int second) {
		this.hour = new Display(hour, 24);
		this.minute = new Display(minute, 60);
		this.second = new Display(second, 60);
	}

	// methods
	public void tick() {
		second.tick();
		if (second.getValue() == 0) {
			minute.tick();
			if (minute.getValue() == 0)
				hour.tick();
		}
	}

	public String toString() {
		// 调用Display类中的toString方法
		return hour + ":" + minute + ":" + second;
		// 或者构造一个格式化字符串
		//return String.format("%02d:%02d:%02d", hour.getValue(), minute.getValue(), second.getValue());
	}

}
