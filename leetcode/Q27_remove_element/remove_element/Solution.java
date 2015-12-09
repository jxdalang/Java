/**
* @package remove_element
* @author ZS@ZJU
* @version V1.0
*/
package remove_element;

import java.util.Arrays;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 10, 2015 12:24:40 AM
*/

/**
Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int new_length = 0;
        //遇到不用移除的元素就直接覆盖排列到数组的前部，新长度之后的元素不用管
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[new_length++] = nums[i];
        }

        return new_length;
    }

    // simple test
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums0 = {};
        System.out.println("len = " + s.removeElement(nums0, 1) + ", array = " + Arrays.toString(nums0));
        int[] nums1 = { 1, 1, 1 };
        System.out.println("len = " + s.removeElement(nums1, 1) + ", array = " + Arrays.toString(nums1));
        int[] nums2 = { 1, 1, 2 };
        System.out.println("len = " + s.removeElement(nums2, 4) + ", array = " + Arrays.toString(nums2));
        int[] nums3 = { 1, 2, 1, 5, 3, 6, 5, 5, 2, 4, 8, 7, 7 };
        System.out.println("len = " + s.removeElement(nums3, 3) + ", array = " + Arrays.toString(nums3));
    }
}