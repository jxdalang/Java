/**
* @package roman_to_integer
* @author ZS@ZJU
* @version V1.0
*/
package roman_to_integer;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 30, 2015 1:05:37 PM
*/

/**
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
    public int romanToInt(String s) {
        char[] ca = s.toCharArray();
        int res = 0;
        // 罗马数字转化为阿拉伯数字基本就是从左到右把每个字母代表的数值加起来
        for (int i = 0; i < ca.length; i++) {
            // 唯一的特殊情况是，如果左边字母代表的值比右边字母的小（比如IV，IX，XL等），那么左边的值应该是减掉的
            if ((i + 1) < ca.length && toNumber(ca[i]) < toNumber(ca[i + 1]))
                res = res - toNumber(ca[i]);
            else
                res = res + toNumber(ca[i]);
        }
        return res;
    }

    private int toNumber(char ch) {
        switch (ch) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        }
        return 0;
    }
}