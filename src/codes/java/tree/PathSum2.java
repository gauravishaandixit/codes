package codes.java.tree;

import java.util.ArrayList;

public class PathSum2 {

    ArrayList<ArrayList<Integer>> allPathsToSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        allPathsToSum(root, sum, 0, ans, new ArrayList<>());

        return ans;
    }

    void allPathsToSum(TreeNode root, int totalSum, int currSum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list) {
        if (root == null)
            return;

        currSum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && currSum == totalSum)
            ans.add(new ArrayList<>(list));

        allPathsToSum(root.left, totalSum, currSum, ans, list);
        allPathsToSum(root.right, totalSum, currSum, ans, list);
        list.remove(list.size() - 1);
    }
}
