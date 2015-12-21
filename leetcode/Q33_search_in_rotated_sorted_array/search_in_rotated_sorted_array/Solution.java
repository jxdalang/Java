/**
* @package search_in_rotated_sorted_array
* @author ZS@ZJU
* @version V1.0
*/
package search_in_rotated_sorted_array;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 21, 2015 10:24:36 AM
*/

/**
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class Solution {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[left] <= nums[mid]) { // 中点比左端大，说明左半部分一定是有序的
                if (target < nums[mid] && target >= nums[left]) // 由于左半部分是有序的，所以可以判断target是不是在左半部分
                    right = mid - 1;
                else // 如果不在左半部分，范围缩小到右半部分
                    left = mid + 1;
            } else { // else,右半部分一定是有序的
                if (target > nums[mid] && target <= nums[right]) // 由于右半部分是有序的，所以可以判断target是不是在右半部分
                    left = mid + 1;
                else // 如果不在右半部分，范围缩小到左半部分
                    right = mid - 1;
            }
        }
        return -1;
    }
}