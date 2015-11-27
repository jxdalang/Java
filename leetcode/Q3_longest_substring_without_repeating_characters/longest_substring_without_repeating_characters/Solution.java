/**
* @package longest_substring_without_repeating_characters
* @author ZS@ZJU
* @version V1.0
*/
package longest_substring_without_repeating_characters;

import java.util.HashMap;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 27, 2015 6:10:57 PM
*/

/**
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> char_index = new HashMap<>();
        int current_len = 0, max_len = 0;
        int current_start = 0;
        for (int i = 0; i < s.length(); i++) {
            Character current_char = s.charAt(i);

            if (char_index.containsKey(current_char)) {
                // 调整当前不重复子串的起始位置
                if (current_start <= char_index.get(current_char))
                    current_start = char_index.get(current_char) + 1;
            }

            // 用hashmap记录当前字符的最后出现位置，当出现重复时也会更新这个位置
            char_index.put(current_char, i);

            // 计算当前不重复子串的长度，并更新max_len
            current_len = i - current_start + 1;
            if (current_len > max_len)
                max_len = current_len;
        }

        return max_len;
    }
}