package codes.java.tree;

public class CountIfSubtree {

    int CountIfSubtree(TreeNode root1, TreeNode root2)
    {
        if(isSubtree(root1, root2))
            return countNodesInTree(root2);
        else
            return 0;
    }

    private boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    int countNodesInTree(TreeNode root)
    {
        if(root == null)
            return 0;

        return 1+ countNodesInTree(root.left) + countNodesInTree(root.right);
    }
}
