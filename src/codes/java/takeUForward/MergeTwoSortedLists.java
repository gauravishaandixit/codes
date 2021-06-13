package codes.java.takeUForward;

import codes.java.linkedlist.ListNode;

public class MergeTwoSortedLists {
    ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode last = dummyHead;
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                last.next = head1;
                head1 = head1.next;
            }
            else {
                last.next = head2;
                head1 = head2.next;
            }
            last = last.next;
        }

        if(head1 == null)
            last.next = head2;

        if(head2 == null)
            last.next = head1;

        return dummyHead.next;
    }
}
