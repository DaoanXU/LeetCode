package same_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import _dependency.TreeNode;

public class SolutionOJ {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return OJ(p).toString().equals(OJ(q).toString());
    }

    ArrayList<Integer> OJ(TreeNode p) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        queue.offer(p);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                result.add(null);
                continue;
            }
            
            result.add(current.val);
            queue.offer(current.left);
            queue.offer(current.right);
        }
        return result;
    }

}
