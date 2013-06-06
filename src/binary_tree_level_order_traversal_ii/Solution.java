package binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import _dependency.TreeNode;

public class Solution {

    class TreeIterator {

        Queue<TreeNode> queue;

        TreeIterator(TreeNode node) {
            queue = new LinkedList<TreeNode>();
            queue.offer(node);
            if (node != null)
                queue.offer(null);
        }

        boolean hasNext() {
            return !queue.isEmpty();
        }

        TreeNode next() {
            TreeNode head = queue.poll();
            if (head == null) {
                if (!queue.isEmpty())
                    queue.offer(null);
                return null;
            }

            if (head.left != null)
                queue.offer(head.left);
            if (head.right != null)
                queue.offer(head.right);
            return head;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        TreeIterator iterator = new TreeIterator(root);

        while (iterator.hasNext()) {
            TreeNode current = iterator.next();
            if (current == null) {
                result.add(row);
                row = new ArrayList<Integer>();
            }
            else {
                row.add(current.val);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
