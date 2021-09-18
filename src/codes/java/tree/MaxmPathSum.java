package codes.java.tree;

public class MaxmPathSum {
    int maxPathSum(TreeNode root)
    {
        if(root == null)
            return 0;
        int[] ans = {Integer.MIN_VALUE};
        calculate(root, ans);
        return ans[0];
    }

    int calculate(TreeNode root, int[] ans)
    {
        if(root == null)
            return 0;

        int left = Math.max(calculate(root.left, ans), 0);
        int right = Math.max(calculate(root.right, ans), 0);

        ans[0] = Math.max(left + right + root.val , ans[0]);

        return Math.max(left, right) + root.val;
    }
}
