/**
* @package letter_combinations_of_a_phone_number
* @author ZS@ZJU
* @version V1.0
*/
package letter_combinations_of_a_phone_number;

import java.util.LinkedList;
import java.util.List;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 8, 2015 4:40:56 PM
*/

/**
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution {
    final String BUTTON_MAP[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        if (digits.length() != 0)
            dfs(ret, "", 0, digits.toCharArray());
        return ret;
    }

    private void dfs(List<String> solution_set, String solution, int digit_index, char[] digits) {
        if (digit_index == digits.length) {
            solution_set.add(solution.toString());
            return;
        }

        String current_letters = BUTTON_MAP[digits[digit_index] - '0'];

        if (current_letters.length() == 0)
            dfs(solution_set, solution, digit_index + 1, digits);
        else {
            for (int i = 0; i < current_letters.length(); i++)
                dfs(solution_set, solution + current_letters.charAt(i), digit_index + 1, digits);
        }
    }

    // simple test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
        System.out.println(s.letterCombinations("195"));
        System.out.println(s.letterCombinations("2011"));
    }

}