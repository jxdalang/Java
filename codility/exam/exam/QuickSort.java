package exam;

import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] array, int low, int high) {
        int pivotValue = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivotValue)
                high--;
            array[low] = array[high];
            while (low < high && array[low] <= pivotValue)
                low++;
            array[high] = array[low];
        }
        // low 最后成为支点的位置
        array[low] = pivotValue;
        return low;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[] { 4, 5, 2, 1, 6, 8, 0 };
        QuickSort.quickSort(a, 0, 5);
        System.out.print(Arrays.toString(a));
    }

}
