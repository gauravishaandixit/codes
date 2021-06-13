package codes.java.takeUForward;

import codes.java.linkedlist.ListNode;

public class ReverseLinkedList {
    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
