/**
* @package prefix_sums
* @author ZS@ZJU
* @version V1.0
*/
package prefix_sums;

/**
A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
*/
public class MinAvgTwoSlice {
    /**
     Every slice must be of length two or three.
     Slices of bigger lengths are created from such smaller slices.
     Therefore should any bigger slice have an optimal value,
     all sub-slices must be the same, for this case to hold true.
     
     So, just check all possible slices of length 2,3 is enough.
     */
    public int solution(int[] A) {
        // write your code in Java SE 8
        double min = 10001;
        int min_index = A.length - 1;

        // slice length = 2
        for (int i = 0; i <= A.length - 2; i++) {
            double avg = (A[i] + A[i + 1]) / 2.0;
            if (Double.compare(avg, min) < 0) {
                min = avg;
                min_index = i;
            } else if (Double.compare(avg, min) == 0 && i < min_index) {
                min_index = i;
            }
        }

        // slice length = 3
        for (int i = 0; i <= A.length - 3; i++) {
            double avg = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
            if (Double.compare(avg, min) < 0) {
                min = avg;
                min_index = i;
            } else if (Double.compare(avg, min) == 0 && i < min_index) {
                min_index = i;
            }
        }
        
        return min_index;
    }
}
