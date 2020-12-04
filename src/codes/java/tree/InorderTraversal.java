package codes.java.tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

    ArrayList<Integer> inorderTraversal(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null)
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

}
