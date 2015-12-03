/**
* @package palindrome_number
* @author ZS@ZJU
* @version V1.0
*/
package palindrome_number;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 28, 2015 4:44:48 PM
*/

/**
Determine whether an integer is a palindrome.
 */
public class Solution {

    // 转化为字符进行判断的方法
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        Integer xx = x;
        char[] x_char_array = xx.toString().toCharArray();
        for (int i = 0, j = (x_char_array.length - 1); i <= j; i++, j--) {
            if (x_char_array[i] != x_char_array[j])
                return false;
        }

        return true;
    }

    // 直接利用数字特性进行判断的方法
    public boolean isPalindrome_integer(int x) {
        if (x < 0)
            return false;
        
        //通过求逆序数的方式判断
        int rev = 0;
        while (x > rev) {   //这里判断条件不是x>0是因为只需逆序一半的位数就行了，这样就不必处理overflow
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10); //分别对应x的位数为偶和奇的情况
    }
}