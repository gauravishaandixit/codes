package codes.java.takeUForward;

import codes.java.linkedlist.ListNode;

public class MiddleOfLinkedList {
    ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
