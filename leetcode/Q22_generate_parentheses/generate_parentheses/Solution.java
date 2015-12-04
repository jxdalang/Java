/**
* @package generate_parentheses
* @author ZS@ZJU
* @version V1.0
*/
package generate_parentheses;

import java.util.LinkedList;
import java.util.List;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 3, 2015 12:04:56 PM
*/

/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String str, int open, int close, int n) {
        // open和close分别记录当前传入的str中'('和')'的个数
        // n是需要使用的括号对个数

        // 如果str中已经有n对括号了，说明str是一个有效的解，将其加入list中
        if (str.length() == n * 2) {
            list.add(str);
            return;
        }

        // 保证每个左括号总有一个对应的右括号，即都是有效的解
        if (open < n)
            backtrack(list, str + '(', open + 1, close, n);
        if (close < open)
            backtrack(list, str + ')', open, close + 1, n);

        return;
    }

    // test generateParenthesis method
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(0));
        System.out.println(s.generateParenthesis(1));
        System.out.println(s.generateParenthesis(2));
        System.out.println(s.generateParenthesis(3));
        System.out.println(s.generateParenthesis(4));
    }
}