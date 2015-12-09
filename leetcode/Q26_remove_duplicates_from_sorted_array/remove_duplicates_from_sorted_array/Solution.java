/**
* @package remove_duplicates_from_sorted_array
* @author ZS@ZJU
* @version V1.0
*/
package remove_duplicates_from_sorted_array;

import java.util.Arrays;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 9, 2015 11:56:50 PM
*/

/**
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int new_length = 1; // 当前真正有效的元素个数
        int current_value = nums[0]; // 当前不重复的元素值
        // 找出不重复的元素，直接覆盖排列到数组的前部，新长度之后的元素不用管
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != current_value) {
                nums[new_length++] = nums[i];
                current_value = nums[i];
            }
        }

        return new_length;
    }

    // simple test
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {};
        System.out.println("len = " + s.removeDuplicates(nums1) + ", array = " + Arrays.toString(nums1));
        int[] nums2 = { 1, 1, 2 };
        System.out.println("len = " + s.removeDuplicates(nums2) + ", array = " + Arrays.toString(nums2));
        int[] nums3 = { 1, 1, 2, 3, 5, 5, 5, 5, 7, 8, 8, 9 };
        System.out.println("len = " + s.removeDuplicates(nums3) + ", array = " + Arrays.toString(nums3));
    }
}