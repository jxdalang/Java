/**
* @package generate_parentheses
* @author ZS@ZJU
* @version V1.0
*/
package generate_parentheses;

import java.util.ArrayList;
import java.util.HashSet;
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
        List<String> ret = new ArrayList<>();
        if (n == 1) {
            ret.add("()");
            return ret;
        } else {
            ret = generateParenthesis(n - 1);
            HashSet<String> new_strs = new HashSet<>();
            for (String s : ret) {

                new_strs.add("(" + s + ")");
                new_strs.add("()" + s);
                new_strs.add(s + "()");
            }
            ret.clear();
            ret.addAll(new_strs);
            return ret;
        }
    }

}