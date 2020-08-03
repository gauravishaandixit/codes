package codes.java.tree.construct;


import codes.java.linkedlist.ListNode;
import codes.java.tree.TreeNode;

import java.util.ArrayList;

public class SortedListToBST {

    ArrayList<Integer> list = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        addToArrayList(head);
        return listToBST(0, list.size() - 1);
    }

    public void addToArrayList(ListNode head)
    {
        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }
    }

    TreeNode listToBST(int l, int r)
    {
        if(l > r)
            return null;

        int mid = (l+r)/2;
        TreeNode node = new TreeNode(list.get(mid));


        node.left = listToBST(l, mid - 1);
        node.right = listToBST(mid + 1, r);
        return node;
    }

}
