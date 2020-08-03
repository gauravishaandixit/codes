package codes.java.tree;

public class LCA_BST {

    TreeNode lcaBST(TreeNode root, int n1, int n2)
    {
        if(root == null)
            return root;

        if(root.val < n1 && root.val < n2)
            return lcaBST(root.right, n1, n2);

        if(root.val > n1 && root.val > n2)
            return lcaBST(root.left, n1, n2);

        return root;
    }

    public static void main(String[] a)
    {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{5,3,2,4,7,6,8});
        System.out.println(new LCA_BST().lcaBST(root, 2,3).val);
        System.out.println(new LCA_BST().lcaBST(root, 2,8).val);
        System.out.println(new LCA_BST().lcaBST(root, 6,8).val);
        System.out.println(new LCA_BST().lcaBST(root, 2,5).val);
    }
}
