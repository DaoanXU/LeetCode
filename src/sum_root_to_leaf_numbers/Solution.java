package sum_root_to_leaf_numbers;

import _dependency.TreeNode;

public class Solution {

    int pathSum;
    int result;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        this.pathSum = 0;
        this.result = 0;

        traversal(root);
        return result;

    }

    void traversal(TreeNode root) {
        pathSum = pathSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            check();
        }
        else {
            if (root.left != null)
                traversal(root.left);
            if (root.right != null)
                traversal(root.right);
        }

        pathSum = pathSum / 10;
    }

    void check() {
        result += pathSum;
    }
}