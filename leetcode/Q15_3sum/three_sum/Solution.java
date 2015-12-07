/**
* @package three_sum
* @author ZS@ZJU
* @version V1.0
*/
package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 7, 2015 5:46:18 PM
*/

/**
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        // 数组少于3个元素，显然无解
        if (nums.length < 3)
            return ret;

        // 对数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果当前元素和前个元素相等，直接跳过，不然可能会得到相同的解
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // 调用twoSum找出当前元素和数组剩余部分中的某两个元素可能有的解
            List<int[]> pair = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), -nums[i]);
            // 如果有解，那么存入ret这个List中作为返回
            if (!pair.isEmpty()) {
                for (int j = 0; j < pair.size(); j++) {
                    Integer[] solution = { nums[i], pair.get(j)[0], pair.get(j)[1] };
                    ret.add(new ArrayList<Integer>(Arrays.asList(solution)));
                }
            }
        }

        return ret;
    }

    // 找出和为target的两个数的所有不重复解
    private List<int[]> twoSum(int[] nums, int target) {
        // 每个解用数组存储，所有不重复的解组成List作为返回值
        List<int[]> ret = new ArrayList<int[]>();
        if (nums.length < 2)
            return ret;

        int left = 0, right = nums.length - 1;
        // 记录上一个解的左元素的值，用于检测重复，初值设成MAX_VALUE是因为开始时左边元素是数组最小值，不可能与MAX_VALUE相等
        int last_solution = Integer.MAX_VALUE;
        // 左、右两个指针从已排序的数组两端向中间逼近
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                // 如果找到解，先判断和前一个解是否相同
                if (nums[left] != last_solution) {
                    // 如果和上一个解不同，则记录并更新last_solution
                    ret.add(new int[] { nums[left], nums[right] });
                    last_solution = nums[left];
                }
                // 左指针+1，继续扫描数组
                left++;
            } else if (nums[left] + nums[right] < target)
                left++;
            else
                right--;
        }
        return ret;
    }

    // simple test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(s.threeSum(new int[] { 0, 0, 0, 0 }));
    }
}