package path_sum_ii;

import java.util.ArrayList;

import _dependency.TreeNode;

public class Solution {

    int sum;
    ArrayList<TreeNode> path;
    int pathSum;
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<ArrayList<Integer>>();

        this.sum = sum;
        this.path = new ArrayList<TreeNode>();
        this.pathSum = 0;
        this.result = new ArrayList<ArrayList<Integer>>();

        traversal(root);
        return result;

    }

    void traversal(TreeNode root) {
        path.add(root);
        pathSum += root.val;

        if (root.left == null && root.right == null) {
            check();
        }
        else {
            if (root.left != null)
                traversal(root.left);
            if (root.right != null)
                traversal(root.right);
        }

        path.remove(path.size() - 1);
        pathSum -= root.val;
    }

    void check() {
        if (pathSum != sum)
            return;

        ArrayList<Integer> onePath = new ArrayList<Integer>();
        for (TreeNode node : path) {
            onePath.add(node.val);
        }

        result.add(onePath);
    }
}
