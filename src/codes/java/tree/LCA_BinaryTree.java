package codes.java.tree;

public class LCA_BinaryTree {

    TreeNode lowestCommonAncestor(TreeNode root, int n1, int n2)
    {
        if(root == null)
            return root;

        if(root.val == n1 || root.val == n2)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, n1, n2);
        TreeNode right = lowestCommonAncestor(root.right, n1, n2);

        if(left != null && right != null)
            return root;

        return left == null ? right : left;
    }

    public static void main(String[] a)
    {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{5,3,2,4,7,6,8});
        System.out.println(new LCA_BinaryTree().lowestCommonAncestor(root, 2,3).val);
        System.out.println(new LCA_BinaryTree().lowestCommonAncestor(root, 2,8).val);
        System.out.println(new LCA_BinaryTree().lowestCommonAncestor(root, 6,8).val);
        System.out.println(new LCA_BinaryTree().lowestCommonAncestor(root, 2,5).val);
    }
}
