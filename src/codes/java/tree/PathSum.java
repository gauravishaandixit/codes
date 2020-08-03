package codes.java.tree;

public class PathSum {

    boolean hasPathSum(TreeNode root, int sum)
    {
        return hasPathSum(root, sum, 0);
    }

    boolean hasPathSum(TreeNode root, int totalSum, int currSum)
    {
        if(root == null)
            return false;

        currSum += root.val;

        if(root.left == null && root.right == null)
            return totalSum == currSum;

        return hasPathSum(root.left, totalSum, currSum) || hasPathSum(root.right, totalSum, currSum);
    }
}
