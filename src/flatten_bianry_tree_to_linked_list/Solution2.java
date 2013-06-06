package flatten_bianry_tree_to_linked_list;

import _dependency.TreeNode;

public class Solution2 {
    TreeNode previous;
    
    public void flatten(TreeNode root) {
        if(root == null)
            return;        
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        previous = root;
        flatten(left);
        if(previous != root){
            previous.right = right;
            root.right = left;
            root.left = null;            
        }        
        flatten(right);
    }
}
