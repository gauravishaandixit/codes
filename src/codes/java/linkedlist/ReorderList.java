package codes.java.linkedlist;


public class ReorderList {

    ListNode reorderList(ListNode head)
    {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = new ReverseList().reverseList(slow.next);
        slow.next = null;
        merge(head, head2);
        return head;
    }

    void merge(ListNode h1, ListNode h2)
    {
        while(h2 != null)
        {
            ListNode next = h1.next;
            h1.next = h2;
            h1 = h2;
            h2 = next;
        }
    }
}
