/**
* @package container_with_most_water
* @author ZS@ZJU
* @version V1.0
*/
package container_with_most_water;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 30, 2015 12:27:41 PM
*/

/**
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
which together with x-axis forms a container, such that the container contains the most water.
  y ^
    |
    |     a2
    |     |  a3          an
    |  a1 |  |     a5    | 
    |  |  |  |  a4 |     |
    |  |  |  |  |  | ..  |
    --------------------------->
   0   1  2  3  4  5 ..  n     x
Note: You may not slant the container.
 */

/**
解题思路：
The general idea to find some max is to go through all cases where max value can possibly occur and keep updating the max value.
The efficiency of the scan depends on the size of cases you plan to scan. To increase efficiency,
all we need to do is to find a smart way of scan to cut off the useless cases and
meanwhile 100% guarantee the max value can be reached through the rest of cases.

In this problem, the smart scan way is to set two pointers initialized at both ends of the array.
Every time move the smaller value pointer to inner array. Then after the two pointers meet,
all possible max cases have been scanned and the max situation is 100% reached somewhere in the scan. 
 */
public class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        int current_area = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            current_area = Math.min(height[left], height[right]) * (right - left);
            max_area = Math.max(max_area, current_area);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return max_area;
    }
}
