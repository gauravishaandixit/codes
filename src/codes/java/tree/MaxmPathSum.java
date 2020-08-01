package codes.java.tree;

public class MaxmPathSum {
    int ans;
    int maxPathSum(TreeNode root)
    {
        if(root == null)
            return 0;
        ans = Integer.MIN_VALUE;
        calculate(root);
        return ans;
    }

    int calculate(TreeNode root)
    {
        if(root == null)
            return 0;

        int left = Math.max(calculate(root.left), 0);
        int right = Math.max(calculate(root.right), 0);

        ans = Math.max(left + right + root.val , ans);
        return Math.max(left, right) + root.val;
    }
}
