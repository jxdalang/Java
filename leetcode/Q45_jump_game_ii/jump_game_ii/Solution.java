/**
* @package jump_game_ii
* @author ZS@ZJU
* @version V1.0
*/
package jump_game_ii;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 25, 2015 11:07:47 AM
*/

/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;

        int cur_position = 0; // 记录当前位置
        int jumps = 0; // 记录跳跃次数

        // 当从当前位置还无法一步跳到终点时
        while (nums[cur_position] < (nums.length - 1 - cur_position)) {
            int max_range = 0;
            int step = 0;
            // 贪心算法，找出跳的最大范围max_range（=跳的距离step+目标位置上的值）
            for (int i = 1; i <= nums[cur_position]; i++) {
                if (i + nums[cur_position + i] >= max_range) {
                    max_range = i + nums[cur_position + i];
                    step = i;
                }
            }
            cur_position += step;
            jumps++;
        }

        // while循环结束时说明可以一步跳到终点
        return jumps + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jump(new int[] { 0 }));
        System.out.println(s.jump(new int[] { 1, 1 }));
        System.out.println(s.jump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(s.jump(new int[] { 2, 3, 1, 5, 4, 6, 1, 1, 1, 3, 2 }));
    }
}