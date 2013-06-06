package validate_binary_search_tree;

import _dependency.TreeNode;

public class Solution {
    int currentMax;

    public boolean isValidBST(TreeNode root) {
        currentMax = Integer.MIN_VALUE;
        return isValidBSTHelper(root);
    }

    boolean isValidBSTHelper(TreeNode root) {
        if (root == null)
            return true;

        if (!isValidBSTHelper(root.left))
            return false;

        if (root.val <= currentMax)
            return false;

        currentMax = root.val;
        return isValidBSTHelper(root.right);
    }
}
