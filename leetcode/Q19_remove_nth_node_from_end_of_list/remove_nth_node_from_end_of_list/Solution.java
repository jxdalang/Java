/**
* @package remove_nth_node_from_end_of_list
* @author ZS@ZJU
* @version V1.0
*/
package remove_nth_node_from_end_of_list;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Nov 30, 2015 2:13:40 PM
*/

/**
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
   
Note:
Given n will always be valid.
Try to do this in one pass.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        // 先把q向后移动n个结点
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        // 如果此时q已经不指向任何结点，说明要移除的是头结点
        if (q == null) {
            head = head.next;
            return head;
        }
        // 始终让指针p和q保持n个结点的距离
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        // 当q到达最后一个结点时，p正指向要移除结点的前一个结点
        // 让p的指向跳过下一个结点，就能完成移除操作
        p.next = p.next.next;

        return head;
    }
}
