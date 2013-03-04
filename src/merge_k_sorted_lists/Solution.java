package merge_k_sorted_lists;

import java.util.ArrayList;

/**
 * For easy coding, using recursive for merge.
 * @author Daoan XU
 *
 */

public class Solution {    

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists.size() == 0)
            return null;
        
        int step = 1;
        while (step * 2 <= lists.size()) {
            for (int i = 0; i < lists.size() - step; i = i + step * 2) 
                lists.set(i, merge(lists.get(i), lists.get(i + step)));            
            step = step * 2;
        }
        return step<lists.size() ? merge(lists.get(0), lists.get(step)) : lists.get(0);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }
}
