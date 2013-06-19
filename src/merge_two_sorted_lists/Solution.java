package merge_two_sorted_lists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(0);
        ListNode p = preHead;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (true) {
            if (p1 == null) {
                p.next = p2;
                break;
            }

            if (p2 == null) {
                p.next = p1;
                break;
            }

            if (p1.val < p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }
            else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }

        return preHead.next;
    }
}
