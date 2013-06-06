package populating_next_right_pointers_in_each_node_ii;

import _dependency.TreeLinkNode;

public class Solution {
    public void connect(TreeLinkNode root) {

        if (root == null)
            return;

        root.next = null;

        TreeLinkNode next = connectNextLine(root);
        while (next != null) {
            next = connectNextLine(next);
        }

    }

    public TreeLinkNode connectNextLine(TreeLinkNode first) {

        TreeLinkNode nextPreHead = new TreeLinkNode(0);
        TreeLinkNode next = nextPreHead;
        while (first != null) {
            if (first.left != null) {
                next.next = first.left;
                next = next.next;
            }
            if (first.right != null) {
                next.next = first.right;
                next = next.next;
            }
            first = first.next;
        }
        next.next = null;

        return nextPreHead.next;
    }
}