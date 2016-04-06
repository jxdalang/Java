/**
* @package largest_number
* @author ZS@ZJU
* @version V1.0
*/
package largest_number;

import java.util.Arrays;
import java.util.Comparator;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Apr 6, 2016 11:59:46 PM
*/

/**
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new Integer(nums[i]).toString();
        }

        Arrays.sort(numbers, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        }

        );

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            ret.append(numbers[i]);
        }

        if (ret.toString().charAt(0) == '0')
            return "0";
        else
            return ret.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[] { 3, 30, 34, 5, 9 }));
        System.out.println(s.largestNumber(new int[] { 0, 0, 0 }));
        System.out.println(s.largestNumber(new int[] { 9467049, 36364, 1234 }));
        System.out.println(s.largestNumber(new int[] { 91, 96, 14, 57, 2 }));
    }
}