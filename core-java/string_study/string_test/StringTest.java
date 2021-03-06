package string_test;

public class StringTest {

	public static void main(String[] args) {

		System.out.println("Test1:");
		String s1 = new String("Hello World!");
		String s2 = s1;
		s1 = s1 + " And welcome to Java!";
		System.out.println(s1); // Hello World! And welcome to Java!
		System.out.println(s2); // Hello World!
		System.out.println(s2.charAt(0)); // H
		System.out.println(s2.substring(6, 11)); // World

		System.out.println("\nTest2:");
		String s3 = "Hello World!";
		String s4 = "Hello" + " World!";
		String s5 = "Hello World! And welcome to Java!";
		System.out.println(s2 == s3); // false
		System.out.println(s3 == s4); // true
		System.out.println(s1 == s5); // false

		System.out.println("\nTest3:");
		System.out.println(s2.equals(s3)); // true
		System.out.println(s1.compareTo(s5)); // 0

		System.out.println("\nTest4:");
		String s6 = "expert";
		String s7 = "EXPERT";
		System.out.println(s6.compareTo(s7)); // 32
		System.out.println(s6.equalsIgnoreCase(s7)); // true
		System.out.println(s6.startsWith("ex")); // true
		System.out.println(s7.startsWith("ex")); // false

		System.out.println("\nTest5:");
		String s8 = "String;Split#test,sequence:Using\"regular?expression\"";
		String[] tokens = s8.split("[,.?:; #\"]", 0);
		for (String s : tokens)
			System.out.println(s);

	}

}
