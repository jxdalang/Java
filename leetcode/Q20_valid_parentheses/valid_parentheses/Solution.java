/**
* @package valid_parentheses
* @author ZS@ZJU
* @version V1.0
*/
package valid_parentheses;

import java.util.Stack;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 1, 2015 11:12:34 AM
*/

/**
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> char_stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current_char = s.charAt(i);
            // 如果读入的是左括号，就将其压入堆栈
            if (current_char == '(' || current_char == '{' || current_char == '[')
                char_stack.push(current_char);
            else {
                // ！！注意：pop之前一定要判断堆栈是否为空
                if (char_stack.empty())
                    return false;
                // 如果pop出的栈顶字符不与当前读入的右括号对应
                else if (char_stack.pop() != char_pair(current_char))
                    return false;
            }
        }
        // 如果最后堆栈为空，说明全部括号都一一对应
        if (char_stack.empty())
            return true;
        else
            return false;
    }

    // 返回右括号对应的左括号
    private char char_pair(char c) {
        if (c == ')')
            return '(';
        else if (c == '}')
            return '{';
        else if (c == ']')
            return '[';
        else
            return ' ';
    }
}