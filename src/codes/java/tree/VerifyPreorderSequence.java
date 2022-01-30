package codes.java.tree;

import java.util.Stack;

public class VerifyPreorderSequence {
    boolean verify(int[] pre) {
        int root = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for (int j : pre) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (j < root)
                return false;

            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new root.
            while (!st.isEmpty() && st.peek() < j)
                root = st.pop();

            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            st.push(j);
        }
        return true;
    }

    public static void main(String []ar)
    {
        System.out.println(new VerifyPreorderSequence().verify(new int[]{7,7,10,10, 9,8,5,2}));
        System.out.println(new VerifyPreorderSequence().verify(new int[]{7,2,5,4,12,8,13}));
    }
}
//118000346979253