package codes.java.tree;

public class DiameterOfTree {

    int diameter(TreeNode root)
    {
        if(root == null)
            return 0;

        int dRoot= height(root.left) + height(root.right) + 1;

        int dRootLeft = diameter(root.left);
        int dRootRight = diameter(root.right);

        int ans = Math.max(dRoot, Math.max(dRootLeft, dRootRight));
        return ans;
    }

    int height(TreeNode root)
    {
        if(root == null)
            return 0;

        return Math.max(height(root.left) , height(root.right)) + 1;
    }
}
