package date_test;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Date class Test Sequence
		
		System.out.println("Test1: ");
		Date dateGen = new Date();
		System.out.println("Current date and time: " + dateGen.toString());
		System.out.println("The elapsed time: " + dateGen.getTime());
		
		System.out.println("Test2: ");
		Date dateSet = new Date(30000);
		System.out.println("The elapsed time: " + dateSet.getTime());
		System.out.println("Current date and time: " + dateSet.toString());
		
	}

}
