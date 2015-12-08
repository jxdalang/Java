/**
* @package four_sum
* @author ZS@ZJU
* @version V1.0
*/
package four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 8, 2015 10:34:58 AM
*/

/**
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        // 数组少于4个元素，显然无解
        if (nums.length < 4)
            return ret;

        // 对数组排序
        Arrays.sort(nums);

        // 在3sum的基础上拓展成4sum，复杂度O(n^3)
        for (int i = 0; i < nums.length - 3; i++) {
            // 如果当前元素和前个元素相等，直接跳过，不然可能会得到相同的解，当然第一次不能判断
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // 如果当前元素和前个元素相等，直接跳过，不然可能会得到相同的解，当然第一次不能判断
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1, right = nums.length - 1;
                int last_solution_left = Integer.MAX_VALUE;
                while (left < right) {
                    if (nums[left] + nums[right] + nums[i] + nums[j] == target) {
                        // 如果找到解，先判断和前一个解是否相同
                        if (nums[left] != last_solution_left) {
                            // 如果和上一个解不同，则更新last_solution
                            last_solution_left = nums[left];
                            // 并将该解组成一个List添加到解集ret中
                            ArrayList<Integer> solution = new ArrayList<Integer>();
                            solution.add(nums[i]);
                            solution.add(nums[j]);
                            solution.add(nums[left]);
                            solution.add(nums[right]);
                            ret.add(solution);
                        }
                        // 左指针+1，继续扫描数组
                        left++;
                    } else if (nums[left] + nums[right] + nums[i] + nums[j] < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return ret;
    }

    // simple test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
        System.out.println(s.fourSum(new int[] { 0, 0, 0, 0, 0, 0 }, 0));
    }
}
