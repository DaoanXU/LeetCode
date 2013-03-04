package remove_nth_node_from_end_of_list;
public class SolutionStack {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode result;
    private ListNode head;
    private int count;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        count = 0;
        result = head;
        this.head = head;
        findit(head,n);
        
        return result;
    }
    
    private void findit(ListNode current, int n){
        if(current == null){
            count = 0;
            return;
        }
        findit(current.next,n);
        count++;
        if(count == n){
            if(current == head)
                result = head.next;
        }
        if(count == n+1){
            current.next = current.next.next;
        }
    }
}
