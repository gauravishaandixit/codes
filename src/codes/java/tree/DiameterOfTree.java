package codes.java.tree;

public class DiameterOfTree {

    public int diameterOfBinaryTree(TreeNode root)
    {
        int[] ans = {0};
        maxDepth(root, ans);
        return ans[0];
    }

    private int maxDepth(TreeNode root, int[] ans) {
        if (root == null) return 0;

        int left = maxDepth(root.left, ans);
        int right = maxDepth(root.right, ans);

        ans[0] = Math.max(ans[0], left + right);

        return Math.max(left, right) + 1;
    }
}
