package remove_duplicates_from_sorted_list_ii;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return null;

        ListNode p = head;
        ListNode t = new ListNode(0);
        t.next = head;
        head = t;

        p = p.next;
        while (p != null) {
            if (t.next.val == p.val) {
                p = p.next;
            }
            else {
                if (t.next.next == p) {
                    t = t.next;
                    p = p.next;
                }
                else {
                    t.next = p;
                    p = p.next;

                }
            }
        }

        if (t.next.next == null)
            return head.next;

        if (t.next.val == t.next.next.val)
            t.next = null;

        return head.next;

    }
}
