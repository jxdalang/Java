/**
* @package next_permutation
* @author ZS@ZJU
* @version V1.0
*/
package next_permutation;

import java.util.Arrays;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 14, 2015 11:54:09 AM
*/

/**
 * 下一个排列
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;

        int i = nums.length - 2;
        while (i >= 0) {
            // 首先定位i至nums[i] >= nums[i + 1]的位置,然后生成下一个排列
            if (nums[i] < nums[i + 1]) {
                // 对nums[i]后面的所有元素排序
                Arrays.sort(nums, i + 1, nums.length);
                int j = i + 1;
                // 定位j
                while (i < nums.length && nums[i] >= nums[j])
                    j++;
                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                return;
            }
            i--;
        }

        // 如果定位不到i，说明当前序列是最后一种排列了
        // rearrange it as the lowest possible order (sorted in ascending order)
        Arrays.sort(nums);
        return;
    }

    // simple test
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = { 1, 3, 2 };
        s.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = { 2, 3, 1 };
        s.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = { 1, 5, 1 };
        s.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}