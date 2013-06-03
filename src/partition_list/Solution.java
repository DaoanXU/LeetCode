package partition_list;

import _dependency.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {

        if (head == null)
            return null;

        ListNode preHead1 = new ListNode(0);
        ListNode preHead2 = new ListNode(0);

        ListNode p1 = preHead1;
        ListNode p2 = preHead2;

        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            }
            else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = preHead2.next;
        p2.next = null;
        return preHead1.next;
    }
}