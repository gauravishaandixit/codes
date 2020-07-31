package codes.java.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBST {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        makeString(root, sb);
        return sb.toString();
    }

    void makeString(TreeNode root, StringBuilder sb)
    {
        if(root == null)
            return;

        sb.append(root.val).append(",");
        makeString(root.left, sb);
        makeString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        return buildTree(new LinkedList<>(Arrays.asList(data.split(","))), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode buildTree(Queue<String> q, int min, int max)
    {
        if (q.isEmpty()) return null;
        String curr = q.peek();
        int val = Integer.valueOf(curr);

        if(val < min || val > max)
            return null;
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = buildTree(q, min, val);
        root.right = buildTree(q, val, max);

        return root;
    }

}
