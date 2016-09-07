/**
* @package prefix_sums
* @author ZS@ZJU
* @version V1.0
*/
package prefix_sums;

import java.util.HashMap;

/**
 * 从只含1，-1的数组中找出最长的和为0的子串长度
*/
public class LongestZeroSumSeq {
    public static int longestZeroSumSeq(int[] A) {
        int ret = 0;
        int len = A.length;
        int[] sum_index = new int[len];
        int sum = 0;

        // calculate prefix_sums
        for (int i = 0; i < len; i++) {
            sum += A[i];
            sum_index[i] = sum;
        }

        // sum of subSeq(i~j) = sum_index[j] - sum_index[i] = 0
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(sum_index[i])) {
                if (i - map.get(sum_index[i]) > ret)
                    ret = i - map.get(sum_index[i]);
            } else
                map.put(sum_index[i], i);
        }

        return ret;
    }

    public static void main(String args[]) {
        System.out.print(LongestZeroSumSeq.longestZeroSumSeq(new int[] { 1, -1, -1, -1, 1, 1, 1, -1, 1 }));
    }

}
