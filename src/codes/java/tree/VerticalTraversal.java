package codes.java.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTraversal {
    ArrayList<ArrayList<Integer>> verticalOrder(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        helper(root, 0, map);

        ans.addAll(map.values());

        return ans;
    }

    void helper(TreeNode root, int hd, Map<Integer, ArrayList<Integer>> map)
    {
        if(root == null)
            return;

        map.computeIfAbsent(hd, k -> new ArrayList<>()).add(root.val);

        helper(root.left, hd - 1, map);
        helper(root.right, hd + 1, map);
    }

    public static void main(String[] ar)
    {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{5,3,2,4,7,6,8});
        System.out.println(new VerticalTraversal().verticalOrder(root));
    }
}
