package codes.java.tree;

import java.util.*;

public class NodesAtDistanceK {

    ArrayList<TreeNode> nodesAtKDistance(TreeNode root, TreeNode start, int k)
    {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if(root == null)
            return ans;

        HashMap<TreeNode, TreeNode> parMap = new HashMap<>();
        parentMapping(root, null, parMap);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        q.add(start);
        vis.add(start);

        int currLev = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            while(size --> 0)
            {
                TreeNode curr = q.poll();
                if(currLev == k)
                    ans.add(curr);
                else
                {
                    if(curr.left != null && vis.add(curr.left))
                        q.add(curr.left);

                    if(curr.right != null && vis.add(curr.right))
                        q.add(curr.right);

                    if(parMap.get(curr) != null && vis.add(parMap.get(curr)))
                        q.add(parMap.get(curr));
                }
            }
            currLev++;
        }
        return ans;
    }

    void parentMapping(TreeNode child, TreeNode parent, HashMap<TreeNode, TreeNode> parMap)
    {
        if(child == null)
            return;

        parMap.put(child, parent);
        parentMapping(child.left, child, parMap);
        parentMapping(child.right, child, parMap);
    }
}
