package codes.java.linkedlist;


//1 1 1 1 2 3 ==> 2 3
// 1 1 2 3 3 4 ==> 2 4
//retain only distincts
public class DeleteDuplicates2 {

    ListNode deleteAllDuplicates(ListNode head)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, prev = dummy;

        while(curr != null)
        {
            while(curr.next != null && curr.val == curr.next.val)
                curr = curr.next;

            if(prev.next == curr) // cur.val is distinct, move pre to next node
                prev = prev.next;
            else                 // skip duplicates, but pre shouldn't move now
                prev.next = curr.next;

            curr = curr.next;
        }
        return dummy.next;
    }
}
