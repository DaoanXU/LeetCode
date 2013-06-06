package convert_sorted_list_to_binary_search_tree;

import _dependency.ListNode;
import _dependency.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        int[] num = new int[count];
        p = head;
        count = 0;
        while (p != null) {
            num[count] = p.val;
            count++;
            p = p.next;
        }

        if (num.length == 0)
            return null;
        return BST(num, 0, num.length - 1);

    }

    TreeNode BST(int[] num, int fromIndex, int endIndex) {
        if (fromIndex > endIndex)
            return null;

        int midIndex = (fromIndex + endIndex) >>> 1;
        TreeNode newOne = new TreeNode(num[midIndex]);
        newOne.left = BST(num, fromIndex, midIndex - 1);
        newOne.right = BST(num, midIndex + 1, endIndex);
        return newOne;
    }
}