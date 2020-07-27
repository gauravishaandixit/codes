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
            if(curr.next != null)
                minHeap.add(curr.next);
        }
        return dummy.next;
    }
}
