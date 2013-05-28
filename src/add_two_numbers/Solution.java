package add_two_numbers;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode previous = null;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            current.val = sum % 10;
            carry = sum > 9 ? 1 : 0;

            current.next = new ListNode(0);
            previous = current;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null)
            l1 = l2;

        while (l1 != null) {
            int sum = l1.val + carry;
            current.val = sum % 10;
            carry = sum > 9 ? 1 : 0;

            current.next = new ListNode(0);
            previous = current;
            current = current.next;
            l1 = l1.next;
        }

        if (carry == 1)
            current.val = 1;
        else
            previous.next = null;

        return head;
    }
}
