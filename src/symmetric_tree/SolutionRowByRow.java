package symmetric_tree;

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
        
        TreeNode rightNext(){
            TreeNode head = queue.poll();
            if (head.right != null)
                queue.offer(head.right);
            if (head.left != null)
                queue.offer(head.left);
            return head;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        TreeNode p = root.left;
        TreeNode q = root.right;
        
        if (p == null)
            return q == null;
        if (q == null)
            return p == null;

        TreeIterator ip = new TreeIterator(p);
        TreeIterator iq = new TreeIterator(q);

        while (ip.hasNext() && iq.hasNext()) {
            if (!equalNode(ip.next(), iq.rightNext()))
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

        if (p.left == null || q.right == null)
            if (!(p.left == null && q.right == null))
                return false;

        if (p.right == null || q.left == null)
            if (!(p.right == null && q.left == null))
                return false;

        if (p.left != null)
            result = result && p.left.val == q.right.val;
        if (p.right != null)
            result = result && p.right.val == q.left.val;
        return result;
    }

}
