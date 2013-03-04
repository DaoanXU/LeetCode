package reverse_nodes_in_k_group;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        if (k <= 1)
            return head;

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode preNode = preHead;
        while(preNode.next != null){
            preNode = reverseGroup(preNode,k,false);
        }

        return preHead.next;
    }

    public ListNode reverseGroup(ListNode preNode, int k, boolean force) {
        ListNode tail = preNode.next;

        ListNode current = preNode.next;
        ListNode previous = preNode;
        ListNode next = current.next;
        int i = 0;
        for (i = 0; i < k && current != null; i++) {
            current.next = previous;
            previous = current;
            current = next;
            next = current == null ? null : current.next;
        }

        preNode.next = previous;
        tail.next = current;
        
        if(i<k && !force)
            return reverseGroup(preNode, k,true);
        
        return tail;
    }
}
