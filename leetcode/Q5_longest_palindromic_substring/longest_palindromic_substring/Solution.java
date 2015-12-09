/**
* @package longest_palindromic_substring
* @author ZS@ZJU
* @version V1.0
*/
package longest_palindromic_substring;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 9, 2015 12:26:41 PM
*/

/**
Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Solution {
    private int start_index = 0;
    private int max_length = 0;

    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;

        for (int i = 0; i < s.length() - 1; i++) {
            extend(s, i, i); // 假设回文串含有奇数个字符
            extend(s, i, i + 1); // 假设回文串含有偶数个字符
        }

        return s.substring(start_index, max_length + start_index);
    }

    // 从中心开始向两边扩展出一个回文串
    private void extend(String s, int left_index, int right_index) {
        while (left_index >= 0 && right_index < s.length() && s.charAt(left_index) == s.charAt(right_index)) {
            left_index--;
            right_index++;
        }

        // 更新最长回文串
        int current_length = (right_index - 1) - (left_index + 1) + 1;
        if (current_length > max_length) {
            max_length = current_length;
            start_index = left_index + 1;
        }
    }

    // simple test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("a"));
        System.out.println(s.longestPalindrome("axcbca"));
    }

}
