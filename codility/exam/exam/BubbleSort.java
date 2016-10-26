
package exam;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = n - 1; i >= 1; i--) {
            System.out.println("Loop - " + (n - i));
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int swapTemp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = swapTemp;
                    sorted = false;
                }
            }
            if (sorted)
                break;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[] { -2, -1, 4, 5, 2, 1, 6, 8, 0 };
        BubbleSort.bubbleSort(a);
        System.out.print(Arrays.toString(a));
    }

}
