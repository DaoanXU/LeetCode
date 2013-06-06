package path_sum;

import java.util.ArrayList;

import _dependency.TreeNode;

public class Solution {

    int sum;
    ArrayList<TreeNode> path;
    int pathSum;
    boolean result;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        this.sum = sum;
        this.path = new ArrayList<TreeNode>();
        this.pathSum = 0;
        this.result = false;

        traversal(root);
        return result;

    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        path.add(root);
        pathSum += root.val;

        if (root.left != null)
            traversal(root.left);
        if (root.right != null)
            traversal(root.right);

        if (root.left == null && root.right == null)
            check();

        path.remove(path.size() - 1);
        pathSum -= root.val;
    }

    void check() {
        if (pathSum == sum)
            result = true;
    }
}
