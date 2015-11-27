/**
* @package add_two_numbers
* @author ZS@ZJU
* @version V1.0
*/
package add_two_numbers;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 27, 2015 6:06:43 PM
*/

/**
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int sum;
        int carry = 0;

        while (p1 != null) {
            // add
            sum = p1.val + p2.val + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            p2.val = sum;

            // when l2 is shorter than l1
            if (p2.next == null && p1.next != null) {
                p2.next = p1.next;
                break;
            }

            // move forward
            p1 = p1.next;
            if (p1 != null && p2.next != null)
                p2 = p2.next;
        }

        // process carry
        while (carry == 1) {
            if (p2.next == null) {
                ListNode temp = new ListNode(0);
                p2.next = temp;
            }
            p2 = p2.next;
            p2.val += carry;
            if (p2.val < 10)
                carry = 0;
            else
                p2.val = p2.val % 10;
        }

        return l2;
    }
}