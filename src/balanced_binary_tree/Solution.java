package balanced_binary_tree;

import _dependency.TreeNode;

public class Solution {
    public int height(TreeNode root) {

        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        if (left < 0 || right < 0)
            return -1;

        if (left < right - 1 || left > right + 1)
            return -1;

        if (left > right)
            return left + 1;

        return right + 1;
    }

    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
            return true;
        
        int left = height(root.left);
        int right = height(root.right);

        if (left < 0 || right < 0)
            return false;

        if (left < right - 1 || left > right + 1)
            return false;

        return true;

    }
}