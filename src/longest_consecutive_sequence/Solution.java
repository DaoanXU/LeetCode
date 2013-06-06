package longest_consecutive_sequence;

import java.util.HashMap;
import java.util.HashSet;

import _dependency.ListNode;

public class Solution {

    HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    HashSet<ListNode> heads = new HashSet<ListNode>();

    public int longestConsecutive(int[] num) {
        map.clear();
        heads.clear();

        for (int n : num) {
            if (map.containsKey(n))
                continue;

            ListNode node = new ListNode(n);
            map.put(n, node);

            node.next = null;
            if (map.containsKey(n + 1)) {
                node.next = map.get(n + 1);
                heads.remove(node.next);
            }

            if (map.containsKey(n - 1)) {
                map.get(n - 1).next = node;
            }
            else {
                heads.add(node);
            }
        }
        int max = 0;
        for (ListNode node : heads) {
            max = Math.max(max, size(node));
        }

        return 0;
    }

    int size(ListNode node) {
        int count = 0;
        while (node != null)
        {
            count++;
            node = node.next;
        }
        return count;
    }
}
