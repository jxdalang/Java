/**
* @package integer_to_roman
* @author ZS@ZJU
* @version V1.0
*/
package integer_to_roman;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 30, 2015 12:36:16 PM
*/

/**
Given an integer, convert it to a roman numeral（罗马数字）.
Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
    public String intToRoman(int num) {
        String[][] roman = { 
                { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
                { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
                { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }, 
                { "", "M", "MM", "MMM" }
                };
        StringBuilder res = new StringBuilder();
        char[] ca = ((Integer) num).toString().toCharArray();

        // 把每一位数转换为对应的罗马数字连起来就行
        for (int i = 0; i < ca.length; i++) {
            res = res.append(roman[ca.length - 1 - i][ca[i] - '0']);
        }
        return res.toString();
    }
}