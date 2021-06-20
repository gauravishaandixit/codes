package codes.java.linkedlist;

public class Palindrome {
    boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) // Odd Number of Nodes
            slow = slow.next;

        ListNode head1 = reverseLinkedList(slow);
        ListNode head2 = head;

        while(head1 != null)
        {
            if(head1.val != head2.val)
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return true;

    }

    ListNode reverseLinkedList(ListNode head)
    {
        ListNode curr = head, prev = null;
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
