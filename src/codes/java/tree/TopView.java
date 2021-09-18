package codes.java.tree;

import java.util.*;

public class TopView {
    static class Pair
    {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }

    ArrayList<Integer> topView(TreeNode root)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty())
        {
            Pair curr = q.poll();

            if(!map.containsKey(curr.hd))
                map.put(curr.hd, curr.node.val);

            if(curr.node.left != null)
                q.add(new Pair(curr.node.left, curr.hd - 1));

            if(curr.node.right != null)
                q.add(new Pair(curr.node.right, curr.hd + 1));
        }
        //System.out.println(map);
        return new ArrayList<>(map.values());
    }

    public static void main(String[] a)
    {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{5,3,2,4,7,6,8});
        System.out.println(new TopView().topView(root));
    }
}
