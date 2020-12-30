package codes.java.tree;


import java.util.*;

public class ClosestLeafNode {
    TreeNode start = null;
    int closetLeaf(TreeNode root, int k)
    {
        if(root == null)
            return -1;

        findNode(root, k);

        if(start.left == null && start.right == null)
            return 0;

        HashMap<TreeNode, TreeNode> parMap = new HashMap<>();
        parentMapping(root, null, parMap);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        q.add(start);
        vis.add(start);

        while(!q.isEmpty())
        {
            int size = q.size();
            while(size --> 0) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null)
                    return curr.val;
                else {
                    if (curr.left != null && vis.add(curr.left))
                        q.add(curr.left);

                    if (curr.right != null && vis.add(curr.right))
                        q.add(curr.right);

                    if (parMap.get(curr) != null && vis.add(parMap.get(curr)))
                        q.add(parMap.get(curr));
                }
            }
        }
        return 0;
    }


    void parentMapping(TreeNode child, TreeNode parent, HashMap<TreeNode, TreeNode> parMap)
    {
        if(child == null)
            return;

        parMap.put(child, parent);
        parentMapping(child.left, child, parMap);
        parentMapping(child.right, child, parMap);
    }
    void findNode(TreeNode root, int k)
    {
        if(root == null)
            return;

        if(root.val == k)
            start = root;

        findNode(root.left, k);
        findNode(root.right, k);
    }
}
