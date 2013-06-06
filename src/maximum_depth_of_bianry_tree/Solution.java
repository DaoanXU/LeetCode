package maximum_depth_of_bianry_tree;

import _dependency.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}