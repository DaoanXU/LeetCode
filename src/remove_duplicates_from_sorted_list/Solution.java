package remove_duplicates_from_sorted_list;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return null;

        ListNode p = head;
        ListNode t = head;

        p = p.next;
        while (p != null) {
            if (t.val == p.val) {
                p = p.next;
            }
            else {
                t.next = p;
                t = p;
                p = p.next;
            }
        }
        t.next = null;
        return head;

    }
}
