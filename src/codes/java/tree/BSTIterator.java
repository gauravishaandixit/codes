package codes.java.tree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root)
    {
        st = new Stack<>();
        TreeNode curr = root;
        while(curr != null)
        {
            st.push(curr);
            curr = curr.left;
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next()
    {
        TreeNode node = st.pop();
        TreeNode curr = node.right;
        while(curr != null)
        {
            st.push(curr);
            curr = curr.left;
        }
        return node.val;
    }
}
