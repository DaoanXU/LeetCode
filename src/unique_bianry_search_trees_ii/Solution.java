package unique_bianry_search_trees_ii;

import java.util.ArrayList;

import _dependency.TreeNode;

public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generate(1, n);

    }

    public ArrayList<TreeNode> generate(int start, int end) {

        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            TreeNode root = null;
            result.add(root);
            return result;
        }

        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftList = generate(start, i - 1);
            ArrayList<TreeNode> rightList = generate(i + 1, end);

            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}