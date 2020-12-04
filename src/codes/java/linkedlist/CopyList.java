package codes.java.linkedlist;

import java.util.HashMap;

public class CopyList {
    static class RandomListNode
    {
        int val;
        RandomListNode next, random;
        RandomListNode(int val)
        {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    RandomListNode copyList(RandomListNode head)
    {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head, clone = null;
        while(curr != null)
        {
            clone = new RandomListNode(curr.val);
            map.put(curr, clone);
            curr = curr.next;
        }

        curr = head;
        while(curr != null)
        {
            clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}
