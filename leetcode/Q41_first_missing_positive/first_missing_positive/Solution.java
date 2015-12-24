/**
* @package first_missing_positive
* @author ZS@ZJU
* @version V1.0
*/
package first_missing_positive;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 23, 2015 10:54:30 PM
*/

/**
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 即不能使用排序
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;

        for (int i = 0; i < nums.length; i++) {
            // 长度为l的数组缺失的第一个正整数一定在1~L+1之间，将当前位置的值（如果在1~L范围内）移动到其对应的坐标+1处（例如1移动到nums[0]处）
            while (nums[i] - 1 != i && (nums[i] > 0 && nums[i] <= nums.length) && (nums[i] != nums[nums[i] - 1])) {
                int val = nums[i];
                nums[i] = nums[val - 1];
                nums[val - 1] = val;
            }
        }

        // 遍历找出第一个值与坐标不对应的地方，就是缺失的正整数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i)
                return i+1;
        }

        //如果所有的值都和坐标对应，说明数组中的值是1~数组长度，那么返回长度+1
        return nums.length + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[] { 1, 1 }));
        System.out.println(s.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
        System.out.println(s.firstMissingPositive(new int[] { 1, 2, 0 }));
    }
}