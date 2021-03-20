package codes.java.linkedlist;

public class MergeSort {

    ListNode mergeSort(ListNode head)
    {
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode head1 = mergeSort(head);
        ListNode head2 = mergeSort(slow);

        return merge(head1, head2);
    }

    ListNode merge(ListNode h1, ListNode h2)
    {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while(h1 != null && h2 != null)
        {
            if(h1.val < h2.val)
            {
                p.next = h1;
                h1 = h1.next;
            }
            else
            {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }

        if(h1 == null)
            p.next = h2;

        if(h2 == null)
            p.next = h1;

        return dummy.next;
    }
}
