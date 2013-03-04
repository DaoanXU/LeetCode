package swap_nodes_in_pairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        
        if(head.next == null)
            return head;
        
        ListNode result = head.next;
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        while(p1 !=null && p2!=null){
            ListNode nextP1 = p2.next;
            ListNode nextP2 = nextP1 == null ? null : nextP1.next;
            p1.next = p2.next == null ? p2.next : p2.next.next == null ? p2.next : p2.next.next;
            p2.next = p1;
            p1 = nextP1;
            p2 = nextP2;
        }        
        
        return result;
    }
}
