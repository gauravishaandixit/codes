package codes.java.linkedlist;

public class KReverseList {
    ListNode kReverseList(ListNode head, int k)
    {
        if(k == 1)
            return head;

        ListNode prev = null, curr = head, next = null;
        int count = 0;

        while(count < k && curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null)
            head.next = kReverseList(next, k);

        return prev;
    }
}
