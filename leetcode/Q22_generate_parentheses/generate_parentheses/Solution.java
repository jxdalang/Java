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
/**
一个solution的要求：
由n个'('和n个')'要组成的一个长度为2n的字符串，且该字符串从左向右看时不会出现'('比')'少的情况，这就能保证不会出现无法匹配的'('

解题思路：在空字符串尾逐个放入圆括号，保证放入的'('比')'多，也就是'('先达到n个，按此顺序找出所有的解。
即：
先放入n个'('，然后剩下的放入')'，得到第一个解
先放入n-1个'('，剩下的1个'('也尽早放入（但不能与第一个解重复了），那么第二个解必然是n-1个'('+一个')'+1个'('+n-1个')'
第三个解就是n-1个'('+2个')'+1个'('+n-2个')'
...
以此类推

这里组成解集的顺序是：所有'('在字符串中索引的和——按从小到大
比如"((()))"中'('的索引是0、1、2，而"(()())"中'('的索引是0、1、3，所以"((()))"在前
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<String>();
        // 调用回溯方法求解，从初始str=空字符串开始寻找解
        addParenthesis(list, "", 0, 0, n);
        return list;
    }

    private void addParenthesis(List<String> list, String str, int open, int close, int n) {
        // open和close分别记录当前传入的str中'('和')'的个数
        // n是目标使用的括号对个数

        // 如果str中已经有n对括号了，说明str已经是一个有效的解，将其加入list中
        if (str.length() == n * 2) {
            list.add(str);
            return;
        }

        // 放入'('
        if (open < n)
            // 递归调用
            addParenthesis(list, str + '(', open + 1, close, n);

        // 放入')'时必须保证其个数不超过'('
        if (close < open)
            // 递归调用
            addParenthesis(list, str + ')', open, close + 1, n);

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