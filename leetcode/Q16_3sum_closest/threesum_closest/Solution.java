/**
* @package threesum_closest
* @author ZS@ZJU
* @version V1.0
*/
package threesum_closest;

import java.util.Arrays;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 7, 2015 11:19:27 PM
*/

/**
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 记录最小差值
        int min_delta = Integer.MAX_VALUE;

        // 对数组排序
        Arrays.sort(nums);

        // 借鉴3sum的思想
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 更新最小差值
                if (Math.abs(target - sum) < Math.abs(min_delta))
                    min_delta = target - sum;
                
                // 两端逼近
                if (target == sum)
                    return target;
                else if (target > sum)
                    left++;
                else
                    right--;
            }
        }

        return (target - min_delta);
    }
}