package codes.java.takeUForward;

import codes.java.linkedlist.ListNode;

public class RemoveNthNodeFromLast {
    ListNode removeNthNode(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy, right = dummy;

        for(int i = 1; i <= n; i++)
            right = right.next;

        while(right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
