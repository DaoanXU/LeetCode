package rotate_list;

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return null;

        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        n = n % size;
        if (n == 0)
            return head;

        ListNode temp = head;
        for (int i = 1; i < size - n; i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        tail.next = head;
        temp.next = null;

        return newHead;
    }
}
