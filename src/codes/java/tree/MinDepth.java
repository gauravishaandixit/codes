package codes.java.tree;

public class MinDepth {

    int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
