package exam;
import java.util.Deque;
import java.util.LinkedList;

public class WindowMaxInt {
    public static void windowMaxInteger(int[] array, int windowSize) {
        if (array == null || array.length == 0 || array.length < windowSize || windowSize <= 0) {
            System.out.print("Invalid input");
        }

        // queue front holds the max value
        Deque<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            // discard all elements in queue smaller than current element
            while (!q.isEmpty() && array[q.peekLast()] < array[i])
                q.pollLast();

            // add current index into queue end
            q.addLast(i);

            // rule out element which is out of the window
            if (q.peekFirst() == i - windowSize) {
                q.pollFirst();
            }

            // print max in each window
            if (i >= windowSize - 1)
                System.out.print(array[q.peekFirst()] + " ");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WindowMaxInt.windowMaxInteger(new int[] { 2, 3, 4, 2, 6, 2, 5, 1 }, 3);

    }

}
