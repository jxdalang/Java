package clock;

public class Main {

	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
		in.close();
		while(true){
			clock.tick();
			System.out.println(clock);
		}
	}

}
