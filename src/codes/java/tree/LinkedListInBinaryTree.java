package codes.java.tree;

import codes.java.linkedlist.ListNode;

public class LinkedListInBinaryTree {

    boolean isSubPath(TreeNode root, ListNode head)
    {
        if(root == null)
            return false;

        if(DFS(root, head)) return true;
        return isSubPath(root.left, head) || isSubPath(root.right, head);
    }

    boolean DFS(TreeNode root, ListNode head)
    {
        if(head == null)
            return true;
        if(root == null)
            return false;

        if(root.val != head.val)
            return false;

        return DFS(root.left, head.next) || DFS(root.right, head.next);
    }
}
