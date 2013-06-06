package reverse_linked_list_ii;

import _dependency.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode preHead = new ListNode(0);
        ListNode pre = preHead;
        preHead.next = head;

        for (int i = 1; i < m; i++)
            preHead = preHead.next;

        reverseGroup(preHead, n - m + 1);
        return pre.next;
    }

    public void reverseGroup(ListNode preNode, int k) {

        ListNode tail = preNode.next;
        ListNode previous = preNode;
        ListNode current = preNode.next;
        ListNode next = preNode.next.next;

        for (int i = 0; i < k; i++) {
            current.next = previous;
            previous = current;
            current = next;
            next = next == null ? null : next.next;
        }

        preNode.next = previous;
        tail.next = current;
    }
}
