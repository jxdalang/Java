package array_test;

import java.util.Arrays;;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Array Test Sequence

		int[] test_array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

		Arrays.sort(test_array);
		System.out.println(Arrays.binarySearch(test_array, 10));

		// Arrays.sort(test_array,2,6);
		// Arrays.fill(test_array, 2, 6, 1);

		System.out.println("\nArray elements:");
		for (int k : test_array)
			System.out.println(k);

	}

}
