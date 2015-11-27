/**
* @package string_to_Integer
* @author ZS@ZJU
* @version V1.0
*/
package string_to_Integer;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 27, 2015 11:08:05 AM
*/

/**
Implement atoi to convert a string to an integer.
 */
public class Solution {
    public int myAtoi(String str) {
        int index = 0;
        int sign = 1, result = 0;

        // 1. handle empty string
        if (str.length() == 0)
            return 0;

        // 2. find index for the first num_char in str
        while (str.charAt(index) - '0' < 0 || str.charAt(index) - '0' > 9) {
            index++;
            // if no num_char in str at all
            if (index == str.length()) {
                return 0;
            }
        }

        // 3. handle signs, multiple signs like "-++-" take effect
        if (index != 0) {
            int sign_index = index - 1;
            while (str.charAt(sign_index) == '+' || str.charAt(sign_index) == '-') {
                sign = (str.charAt(sign_index) == '+' ? 1 : -1) * sign;
                if(sign_index==0)
                    break;
                else
                    sign_index--;
            }
        }

        // 4. convert number
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9)
                break;

            // avoid overflow
            if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE - digit) < result * 10)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = 10 * result + digit;
            index++;
        }

        return result * sign;
    }
    
    //another implementation that only convert the first sequence of non-whitespace characters
    public int myAtoi_limited_convert(String str) {
        int index = 0, sign = 1, result = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if result will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < result || Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = 10 * result + digit;
            index ++;
        }
        return result * sign;
    }
}
