package codes.java.tree;

public class InvertTree {
    TreeNode invertTree(TreeNode root) {
        if(root != null)
        {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
