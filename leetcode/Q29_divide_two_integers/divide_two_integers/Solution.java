/**
* @package divide_two_integers
* @author ZS@ZJU
* @version V1.0
*/
package divide_two_integers;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 13, 2015 11:34:19 AM
*/

/**
Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        // handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == 0)
            return Integer.MAX_VALUE;

        boolean resultIsNegative = (dividend > 0) ^ (divisor > 0);
        long divd = Math.abs((long) dividend);
        long divs = Math.abs((long) divisor);
        int ret = 0;

        // implement division
        // 求商的思想是利用移位操作等价于×2
        // 被除数=(2^i1+2^i2+...+2^i)*除数+余数
        // 即商=2^i1+2^i2+...+2^i，其中i是每轮的counter，可以0,1,2...
        while (divd >= divs) {
            int counter = 0;
            // keep multiply by 2 until divs > divd
            while (divd >= (divs << counter)) {
                counter++;
            }
            // rollback counter so that (divs<<counter) <= divd
            counter--;

            // quotient
            ret += (1 << counter);
            divd -= (divs << counter);
        }

        return resultIsNegative ? -ret : ret;
    }

    // simple test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(0, 0));
        System.out.println(s.divide(-1, 0));
        System.out.println(s.divide(0, -1));
        System.out.println(s.divide(8, 3));
        System.out.println(s.divide(8, -3));
        System.out.println(s.divide(-8, -3));
        System.out.println(s.divide(-8, 3));
    }
}