/**
* @package merge_two_sorted_lists
* @author ZS@ZJU
* @version V1.0
*/
package merge_two_sorted_lists;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 1, 2015 11:24:07 AM
*/

/**
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode p = l1, q = l2;

        // 首先处理q可能插入p前面的情况
        if (p.val > q.val) {
            q = q.next;
            l1 = l2;
            l1.next = p;
            p = l1;
        }

        // 剩下的情况q都只能插入p的后面
        // 循环结束条件是p到达最后一个结点或者q到达空结点（这两种情况必然有一种先发生）
        while (p.next != null && q != null) {
            // 如果p的下一个结点值比q的值大
            if (p.next.val > q.val) {
                // q插入p后面，然后q向后移动一个结点
                ListNode temp = q;
                q = q.next;
                temp.next = p.next;
                p.next = temp;
            } else {
                // p向后移动一个结点
                p = p.next;
            }
        }

        // 最后处理p先到达最后一个结点的情况，把剩下的q链表连接到其后即可
        if (p.next == null) {
            p.next = q;
        }

        return l1;
    }
}