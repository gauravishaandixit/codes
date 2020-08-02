package codes.java.tree;

import java.util.*;

public class BottomView {
    class Pair
    {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }

    ArrayList<Integer> bottomView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty())
        {

            Pair curr = q.poll();
            map.put(curr.hd, curr.node.val);

            if(curr.node.left != null)
                q.add(new Pair(curr.node.left, curr.hd - 1));

            if(curr.node.right != null)
                q.add(new Pair(curr.node.right, curr.hd + 1));
        }

        //System.out.println(map);
        ans.addAll(map.values());
        return ans;
    }
    public static void main(String[] a)
    {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{5,3,2,4,7,6,8});
        System.out.println(new BottomView().bottomView(root));
    }
}
