package convert_sorted_array_to_binary_search_tree;

import _dependency.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
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