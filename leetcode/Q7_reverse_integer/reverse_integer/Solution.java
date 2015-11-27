/**
* @package reverse_integer
* @author ZS@ZJU
* @version V1.0
*/
package reverse_integer;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 27, 2015 10:04:41 AM
*/

/**
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class Solution {

    public int reverse(int x) {
        int result = 0;

        // 取正负号
        int sgn = x > 0 ? 1 : -1;

        // 取绝对值
        x = x > 0 ? x : -x;

        while (x > 0) {
            // 处理下面result的赋值语句overflow的情况
            if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE - x % 10) < result * 10) {
                return 0;
            }

            // 取逆向数
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result * sgn;
    }

//     public static void main(String[] args) {
//     Solution s = new Solution();
//     System.out.println(s.reverse(Integer.MAX_VALUE));
//     }

}
