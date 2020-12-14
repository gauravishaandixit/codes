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

    RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }

}
