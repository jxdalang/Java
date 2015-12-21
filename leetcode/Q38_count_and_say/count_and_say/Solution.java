/**
* @package count_and_say
* @author ZS@ZJU
* @version V1.0
*/
package count_and_say;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 17, 2015 11:09:14 PM
*/

/**
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        else {
            char[] s = countAndSay(n - 1).toCharArray();
            StringBuilder ret = new StringBuilder();
            int count = 1;
            
            for (int i = 0; i < s.length; i++) {
                if (i == s.length - 1 || s[i + 1] != s[i]) {
                    ret.append(count);
                    ret.append(s[i]);
                    count = 1;
                } else
                    count++;
            }
            
            return ret.toString();
        }
    }
}