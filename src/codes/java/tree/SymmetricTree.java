package codes.java.tree;

public class SymmetricTree {
    boolean isSymmetric(TreeNode root)
    {
        return isMirror(root, root);
    }

    boolean isMirror(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null)
            return true;
        else
        {
            if(root1 == null || root2 == null)
                return false;
            else
                return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
    }
}