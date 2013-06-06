package construct_bianry_tree_from_preorder_and_inorder_traversal;

import java.util.HashMap;

import _dependency.TreeNode;

public class Solution {

    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        map.clear();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return build(0, 0, preorder.length);
    }

    TreeNode build(int preFromIndex, int inFromIndex, int length) {
        if (length <= 0)
            return null;

        TreeNode root = new TreeNode(preorder[preFromIndex]);

        int inRootIndex = map.get(root.val);

        root.left = build(
                preFromIndex + 1,
                inFromIndex,
                inRootIndex - inFromIndex);
        root.right = build(
                preFromIndex + inRootIndex - inFromIndex + 1,
                inRootIndex + 1,
                inFromIndex + length - inRootIndex - 1);

        return root;
    }
}
