package binary_tree_maximum_path_sum;

import _dependency.TreeNode;

public class Solution {

    int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        getMax(root);
        return result;
    }

    int getMax(TreeNode root) {
        if (root == null)
            return 0;

        int left = getMax(root.left);
        int right = getMax(root.right);

        install(root.val + left + right);
        install(root.val + left);
        install(root.val + right);
        install(root.val);
        return root.val + Math.max(0, Math.max(left, right));
    }

    void install(int x) {
        if (x > result)
            result = x;
    }
}