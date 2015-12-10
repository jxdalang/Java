/**
* @package inplement_strStr
* @author ZS@ZJU
* @version V1.0
*/
package inplement_strStr;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 10, 2015 9:32:41 AM
*/

/**
Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        // 处理特殊情况
        if (needle.length() == 0)
            return 0;
        else if (haystack.length() == 0)
            return -1;

        // 遍历haystack，遇到needle的第一个字符时，就截取一段长度与needle相等的子串与needle比较
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + needle.length()).equals(needle))
                    return i;
            }
        }
        return -1;
    }
    
    //simple test
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.strStr("", "a"));
        System.out.println(s.strStr("", ""));
        System.out.println(s.strStr("a", ""));
        System.out.println(s.strStr("dgawdwdbtr", "wd"));
    }
}