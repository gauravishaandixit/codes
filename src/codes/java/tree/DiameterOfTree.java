package codes.java.tree;

public class DiameterOfTree {

    int ans;

    public int diameterOfBinaryTree(TreeNode root)
    {
        ans = 0;
        maxDepth(root);
        return ans;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        ans = Math.max(ans, left + right);

        return Math.max(left, right) + 1;
    }
}
