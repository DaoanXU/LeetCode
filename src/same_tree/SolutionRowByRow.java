package same_tree;

import java.util.LinkedList;
import java.util.Queue;

import _dependency.TreeNode;

public class SolutionRowByRow {

    class TreeIterator {

        Queue<TreeNode> queue;

        TreeIterator(TreeNode node) {
            queue = new LinkedList<TreeNode>();
            queue.offer(node);
        }

        boolean hasNext() {
            return !queue.isEmpty();
        }

        TreeNode next() {
            TreeNode head = queue.poll();
            if (head.left != null)
                queue.offer(head.left);
            if (head.right != null)
                queue.offer(head.right);
            return head;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null)
            return q == null;
        if (q == null)
            return p == null;

        TreeIterator ip = new TreeIterator(p);
        TreeIterator iq = new TreeIterator(q);

        while (ip.hasNext() && iq.hasNext()) {
            if (!equalNode(ip.next(), iq.next()))
                return false;
        }

        if (ip.hasNext() || iq.hasNext())
            return false;

        return true;
    }

    public boolean equalNode(TreeNode p, TreeNode q) {
        if (p.val != q.val)
            return false;

        boolean result = true;

        if (p.left == null || q.left == null)
            if (!(p.left == null && q.left == null))
                return false;

        if (p.right == null || q.right == null)
            if (!(p.right == null && q.right == null))
                return false;

        if (p.left != null)
            result = result && p.left.val == q.left.val;
        if (p.right != null)
            result = result && p.right.val == q.right.val;
        return result;
    }
}