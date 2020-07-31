package codes.java.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeBinaryTree {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb)
    {
        if(root == null)
            sb.append("null").append(" ");
        else
        {
            sb.append(root.val).append(" ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> dq = new LinkedList<>();
        dq.addAll(Arrays.asList(data.split(" ")));
        return buildTree(dq);
    }


    TreeNode buildTree(Deque<String> dq)
    {
        String curr = dq.poll();
        if(curr.equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = buildTree(dq);
        root.right = buildTree(dq);

        return root;
    }
}
