package codes.java.takeUForward;

import codes.java.linkedlist.ListNode;

public class RotateList {
    ListNode rotateList(ListNode head, int k) {
        int length = 1;
        ListNode curr = head;
        while(curr.next != null) {
            length++;
            curr = curr.next;
        }

        k = length - k % length;
        curr.next = head;

        while(k -- > 0)
            curr = curr.next;

        head = curr.next;
        curr.next = null;

        return head;
    }
}
