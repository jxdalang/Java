/**
* @package generate_parentheses
* @author ZS@ZJU
* @version V1.0
*/
package generate_parentheses;

import java.util.ArrayList;
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
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            result.add("");
        } else {
            for (int i = n - 1; i >= 0; i--) {
                List<String> insertSub = generateParenthesis(i);
                List<String> tailSub = generateParenthesis(n - 1 - i);
                for (String insert : insertSub) {
                    for (String tail : tailSub) {
                        result.add("(" + insert + ")" + tail);
                    }
                }

            }
        }
        return result;
    }
}