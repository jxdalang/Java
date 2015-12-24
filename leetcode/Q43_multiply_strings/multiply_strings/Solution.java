/**
* @package multiply_strings
* @author ZS@ZJU
* @version V1.0
*/
package multiply_strings;

import java.math.BigInteger;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 23, 2015 5:17:53 PM
*/

/**
Given two numbers represented as strings, return multiplication of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.
 */
public class Solution {

    // 使用JDK
    public String multiply_(String num1, String num2) {

        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        BigInteger ret = n1.multiply(n2);

        return ret.toString();
    }

    // 重新实现，利用乘法竖式的原理
    public String multiply(String num1, String num2) {
        // 建立数组product来保存乘积，两个数乘积的位数不会超过其各自位数的和
        int[] product = new int[num1.length() + num2.length()];

        // num1作为乘数，num2作为被乘数，i、j分别作为每一位的索引
        for (int i = num1.length() - 1; i >= 0; i--)
            for (int j = num2.length() - 1; j >= 0; j--) {
                // 乘数的第i位乘上被乘数的第j位（从0开始计算）
                int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 对应的积p应该保存在product的第h、l位（从0开始计算）
                int h = i + j;
                int l = h + 1;
                // 将p加到product中
                // 这里只处理了低位的进位，高位得到的值可能超过10，但是会在下一个循环中得到处理
                product[h] = (10 * product[h] + product[l] + p) / 10;
                product[l] = (10 * product[h] + product[l] + p) % 10;
            }

        // 将product中的结果转化为字符串
        StringBuilder ret = new StringBuilder();
        // 去掉开头的0
        for (int x : product)
            if (!(ret.length() == 0 && x == 0))
                ret.append(x);
        // 如果最后得到的字符串为空，则说明乘积为0或者输入有空串
        return (ret.length() == 0) ? "0" : ret.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply_("401716832807512840963", "167141802233061013023557397451289113296441069"));
        System.out.println(s.multiply("401716832807512840963", "167141802233061013023557397451289113296441069"));
    }
}