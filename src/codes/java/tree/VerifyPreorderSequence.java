package codes.java.tree;

import java.util.Stack;

public class VerifyPreorderSequence {
    boolean verify(int[] pre) {
        int root = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < pre.length; i++)
        {
            if(root > pre[i])
                return false;

            while(!st.isEmpty() && st.peek() < pre[i])
                root = st.pop();
            //System.out.println(root);
            st.push(pre[i]);
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