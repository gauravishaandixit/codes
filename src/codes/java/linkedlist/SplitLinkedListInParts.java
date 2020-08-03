package codes.java.linkedlist;

public class SplitLinkedListInParts {

    ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode head = root, prev = null;
        while(head != null)
        {
            length++;
            head = head.next;
        }

        int l = length / k, r = length % k;

        ListNode[] parts = new ListNode[k];
        head = root;

        for(int i = 0; head != null && i < k; i++, r--)
        {
            parts[i] = head;
            for(int j = 0; j < l + (r > 0 ? 1 : 0); j++)
            {
                prev = head;
                head = head.next;
            }
            prev.next = null;
        }

        return parts;
    }

}
