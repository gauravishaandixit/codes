package codes.java.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    ListNode mergeKSortedLists(ListNode[] heads)
    {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode head : heads)
        {
            if(head != null)
                minHeap.add(head);
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while(!minHeap.isEmpty())
        {
            ListNode curr = minHeap.poll();
            prev.next = curr;
            prev = prev.next;

            if(curr.next != null)
                minHeap.add(curr.next);
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 0)
            return null;

        ListNode head = mergeTwoList(lists[0], lists[1]);
        for(int i = 2; i < lists.length; i++)
            head = mergeTwoList(head, lists[i]);

        return head;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                head.next = l1;
                l1 = l1.next;
            }
            else
            {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        if(l1 != null)
            head.next = l1;
        if(l2 != null)
            head.next = l2;

        return dummy.next;
    }
}
