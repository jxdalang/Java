package clock;

public class Display {
	private int uplimit = 0;
	private int value = 0;

	// constructor
	public Display(int value, int uplimit) {
		this.value = value;
		this.uplimit = uplimit;
	}

	// methods
	public void tick() {
		value++;
		if (value == uplimit)
			value = 0;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		if (value < 10)
			return "0" + value;
		else
			return "" + value;
	}

}
