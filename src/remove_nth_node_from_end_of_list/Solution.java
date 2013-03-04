package remove_nth_node_from_end_of_list;

public class Solution {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(n<1)
            return head;

        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 1; i < n; i++) {
            if (p2 == null)
                return head;
            p2 = p2.next;
        }
        
        p2 = p2.next;
        if(p2 == null)
            return head.next;
        
        p2 = p2.next;

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;

        return head;
    }
}