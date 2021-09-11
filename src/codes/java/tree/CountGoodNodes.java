package codes.java.tree;

public class CountGoodNodes {

    int countGoodNodes(TreeNode root) {
        int[] ans = new int[1];
        if(root == null)
            return 0;

        dfs(root, -10000, ans);

        return ans[0];

        // return goodNodes(root, -10000);
    }

    int goodNodes(TreeNode root, int curr_max)
    {
        if(root == null)
            return 0;

        int res = root.val >= curr_max ? 1 : 0;
        res += goodNodes(root.left, Math.max(root.val, curr_max));
        res += goodNodes(root.right, Math.max(root.val, curr_max));

        return res;
    }

    private void dfs(TreeNode root, int currMax, int[] ans) {
        if(root == null)
            return;

        if(root.val >= currMax) {
            currMax = root.val;
            ans[0]++;
        }

        dfs(root.left, currMax, ans);
        dfs(root.right, currMax, ans);
    }
}
