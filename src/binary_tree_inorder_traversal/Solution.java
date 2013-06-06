package binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import _dependency.TreeNode;

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> q = new Stack<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();

        if (root == null)
            return result;

        q.push(root);

        while (!q.isEmpty()) {
            TreeNode current = q.pop();
            if (current.left == null || visited.contains(current)) {
                result.add(current.val);
                if (current.right != null)
                    q.push(current.right);
            }
            else {
                q.push(current);
                q.push(current.left);
                visited.add(current);
            }
        }

        return result;

    }
}