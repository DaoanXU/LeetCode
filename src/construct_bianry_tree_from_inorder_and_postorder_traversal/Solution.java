package construct_bianry_tree_from_inorder_and_postorder_traversal;

import java.util.HashMap;

import _dependency.TreeNode;

public class Solution {

    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        map.clear();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return build(0, 0, postorder.length);
    }

    TreeNode build(int postFromIndex, int inFromIndex, int length) {
        if (length <= 0)
            return null;

        TreeNode root = new TreeNode(postorder[postFromIndex + length - 1]);

        int inRootIndex = map.get(root.val);

        root.left = build(
                postFromIndex,
                inFromIndex,
                inRootIndex - inFromIndex);
        root.right = build(
                postFromIndex + inRootIndex - inFromIndex,
                inRootIndex + 1,
                inFromIndex + length - inRootIndex - 1);

        return root;
    }
}