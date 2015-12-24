/**
* @package trapping_rain_water
* @author ZS@ZJU
* @version V1.0
*/
package trapping_rain_water;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 23, 2015 10:28:10 PM
*/

/**
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Solution {
    public int trap(int[] height) {
        // 处理特殊情况
        if (height.length < 2)
            return 0;

        int sum = 0; // 记录围住的总水量
        int hole = 0; // 记录当前“坑”中的水量
        int h = 0; // 记录最高值的索引

        // 计算从左端到最高点围住的水量
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= height[h]) {
                sum += hole;
                hole = 0;
                h = i;
            } else
                hole += height[h] - height[i];
        }

        // 计算从右端到最高点围住的水量（从最右至h处）
        if (h != height.length - 1) {
            hole = 0;
            int h2 = height.length - 1;
            for (int i = height.length - 2; i >= h; i--) {
                if (height[i] >= height[h2]) {
                    sum += hole;
                    hole = 0;
                    h2 = i;
                } else
                    hole += height[h2] - height[i];
            }
        }

        return sum;
    }

    // simple test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

}
