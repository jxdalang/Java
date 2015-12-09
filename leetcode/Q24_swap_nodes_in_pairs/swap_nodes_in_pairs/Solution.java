/**
* @package swap_nodes_in_pairs
* @author ZS@ZJU
* @version V1.0
*/
package swap_nodes_in_pairs;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 9, 2015 12:56:27 PM
*/

/**
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    // 递归解法，需要额外存储空间
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;

        return temp;
    }

    // 传统解法，不需要额外存储空间
    public ListNode swapPairs_classic(ListNode head) {
        // 新建一个头结点，使得head不再需要单独处理
        ListNode start = new ListNode(0);
        start.next = head;

        for (ListNode cur = start; cur.next != null && cur.next.next != null; cur = cur.next.next) {
            cur.next = swap(cur.next, cur.next.next);
        }
        return start.next;
    }

    private ListNode swap(ListNode next1, ListNode next2) {
        next1.next = next2.next;
        next2.next = next1;
        return next2;
    }
}