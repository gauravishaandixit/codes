package codes.java.tree;

public class BalancedBinaryTree {

    boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        int left_height=height(root.left);
        int right_height=height(root.right);

        return Math.abs(left_height - right_height) < 2 && isBalanced(root.left) && isBalanced(root.right);

        // return height2(root) != -1;
    }

    int height(TreeNode root)
    {
        if(root==null)
            return 0;

        int l=height(root.left);
        int r=height(root.right);

        return 1+Math.max(l,r);
    }

    int height2(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = height2(root.left);
        if(leftHeight == -1)
            return -1;

        int rightHeight = height2(root.right);
        if(rightHeight == -1)
            return -1;

        if(Math.abs(leftHeight - rightHeight) >= 2)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
