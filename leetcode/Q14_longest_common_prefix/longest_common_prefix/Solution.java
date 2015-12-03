/**
* @package longest_common_prefix
* @author ZS@ZJU
* @version V1.0
*/
package longest_common_prefix;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 30, 2015 1:14:44 PM
*/

/**
Write a function to find the longest common prefix string amongst an array of strings.
 */

// 容易出错的地方无非空数组、空字符串、下标越界等
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 处理空字符数组
        if (strs.length == 0)
            return "";
        String ret = strs[0];
        for (int i = 1; i < strs.length; i++) {
            ret = longestCommonPrefixOfTwoStrings(ret, strs[i]);
        }

        return ret;
    }

    // find the longest common prefix within 2 strings
    private String longestCommonPrefixOfTwoStrings(String str1, String str2) {
        int min_length = Math.min(str1.length(), str2.length());
        // 处理有空字符串的情况
        if (min_length == 0)
            return "";
        int prefix_len = 0;
        // 计算相同前缀的长度prefix_len
        while (str1.charAt(prefix_len) == str2.charAt(prefix_len)) {
            prefix_len++;
            if (prefix_len == min_length)
                break;
        }
        // 返回前缀子串，注意substring索引到(prefix_len-1)处的字符
        return str1.substring(0, prefix_len);
    }
}