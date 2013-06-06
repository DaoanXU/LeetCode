package flatten_bianry_tree_to_linked_list;

import _dependency.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            rightMost(root.left).right = root.right;
            root.right = root.left;
        }

        root.left = null;

        flatten(root.right);
    }

    TreeNode rightMost(TreeNode root) {
        TreeNode p = root;
        while (p.right != null)
            p = p.right;
        return p;
    }
}
