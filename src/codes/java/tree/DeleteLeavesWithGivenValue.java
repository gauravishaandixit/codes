package codes.java.tree;

public class DeleteLeavesWithGivenValue {

    TreeNode deleteLeaves(TreeNode root, int key)
    {
        if(root == null)
            return null;

        root.left = deleteLeaves(root.left, key);
        root.right = deleteLeaves(root.right, key);

        if(root.left == null && root.right == null && root.val == key)
            return null;

        return root;
    }

}
