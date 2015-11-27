/**
* @package zigzag_conversion
* @author ZS@ZJU
* @version V1.0
*/
package zigzag_conversion;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 26, 2015 11:59:24 PM
*/

/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {
    public String convert(String s, int numRows) {
        // 处理特殊情况
        if (numRows == 1)
            return s;

        // 建立numRows个StringBuilder用于存储各行的字符
        StringBuilder[] result_array = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            result_array[i] = new StringBuilder();
        }
        // 创建一个存储合并后返回字符串的StringBuilder
        StringBuilder result = new StringBuilder();

        // 计算分组长度
        int div = 2 * numRows - 2;

        // 依次处理每个字符
        for (int i = 0; i < s.length(); i++) {
            char current_char = s.charAt(i);

            // 计算当前处理的字符应该位于第几行
            int line_of_char = (i + 1) % div;
            if (line_of_char == 0)
                line_of_char = div;
            if (line_of_char > numRows)
                line_of_char = numRows * 2 - line_of_char;

            // append current_char to corresponding line
            result_array[line_of_char - 1].append(current_char);
        }

        // 组成返回字符串
        for (int i = 0; i < numRows; i++) {
            result.append(result_array[i]);
        }

        return result.toString();
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.convert("PAYPALISHIRING", 3));
//    }

}