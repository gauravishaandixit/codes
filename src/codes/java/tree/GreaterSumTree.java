package codes.java.tree;

import java.util.Stack;

public class GreaterSumTree {

    TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node  = root;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || node != null)
        {
            while(node != null)
            {
                st.add(node);
                node = node.right;
            }
            node = st.pop();
            sum += node.val;
            node.val = sum;

            node = node.left;
        }
        return root;
    }


    private int sum = 0;

    TreeNode convertBSTRec(TreeNode root)
    {
        if (root != null) {
            convertBSTRec(root.right);
            sum += root.val;
            root.val = sum;
            convertBSTRec(root.left);
        }
        return root;
    }

}
