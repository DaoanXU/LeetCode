package recover_binary_search_tree;

import _dependency.TreeNode;

public class Solution {

    TreeNode last;
    int count;

    TreeNode n1;
    TreeNode n2;

    public void recoverTree(TreeNode root) {
        last = new TreeNode(Integer.MIN_VALUE);
        count = 0;
        n1 = null;
        n2 = null;
        recoverHelper(root);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    void recoverHelper(TreeNode root) {
        if (root == null)
            return;

        recoverHelper(root.left);

        if (root.val <= last.val)
            install(root);

        last = root;
        recoverHelper(root.right);
    }

    void install(TreeNode node) {
        if (count == 0) {
            n1 = last;
            count++;
        }
        n2 = node;
    }
}
