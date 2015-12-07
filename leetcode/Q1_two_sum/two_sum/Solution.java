/**
* @package two_sum
* @author ZS@ZJU
* @version V1.0
*/
package two_sum;

import java.util.HashMap;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 27, 2015 5:31:50 PM
*/

/**
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class Solution {
    // O(n)解法有两种，下面这种在解有且只有一个的时候比较好，无需对数组排序
    // 另外一种解法要先对数组排序，然后用头尾两个指针从两头逼近，可以找出多对解，详见Q15
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> pair = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 检查当前的数是否已经在hashmap中
            if (pair.containsKey(nums[i])) {
                // 如果是，说明之前遍历过的数中有和当前数相加得到target的
                result[0] = pair.get(nums[i]) + 1;
                result[1] = i + 1;
                return result;
            } else {
                // 把当前的数与target的差（“另一半”）作为键，当前数的索引作为值存入hashmap
                pair.put(target - nums[i], i);
            }
        }

        return null;
    }
}
