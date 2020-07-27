package codes.java.linkedlist;

public class ReverseList {
    ListNode reverseList(ListNode head)
    {
        ListNode prev = null, curr = head;
        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
