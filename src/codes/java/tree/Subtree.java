package codes.java.tree;

public class Subtree {

    boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;

        if(isSubtreeAtCurrentRoot(s, t))
            return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isSubtreeAtCurrentRoot(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;

        if(s == null || t == null)
            return false;

        if(s.val != t.val)
            return false;

        return isSubtreeAtCurrentRoot(s.left, t.left) && isSubtreeAtCurrentRoot(s.right, t.right);
    }

}
