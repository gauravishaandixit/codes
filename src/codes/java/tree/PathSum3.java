package codes.java.tree;

public class PathSum3 {

    int pathSum3(TreeNode root, int sum) {
        if (root == null)
            return 0;

        return dfs(root, sum, 0) + pathSum3(root.left, sum) + pathSum3(root.right, sum);
    }

    int dfs(TreeNode root, int sum, int curr) {
        if (root == null)
            return 0;

        curr += root.val;

        return (curr == sum ? 1 : 0) + dfs(root.left, sum, curr) + dfs(root.right, sum, curr);
    }
}
