/**
* @package counting_elements
* @author ZS@ZJU
* @version V1.0
*/
package counting_elements;

/**
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0) that does not occur in A.

For example, given:

  A[0] = 1
  A[1] = 3
  A[2] = 6
  A[3] = 4
  A[4] = 1
  A[5] = 2
the function should return 5.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
*/
public class MissingInteger {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        int[] B = new int[len];

        for (int i = 0; i < len; i++) {
            if (A[i] <= len && A[i] >= 1)
                B[A[i] - 1] = 1;
        }
        for (int i = 0; i < len; i++) {
            if(B[i]==0) return (i+1);
        }
        
        return len+1;
    }
}
