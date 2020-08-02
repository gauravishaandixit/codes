package codes.java.tree;

public class TrimBST {

    TreeNode trimBST(TreeNode root, int L, int R)
    {
        if(root == null)
            return root;

        if(root.val < L)
            return trimBST(root.right, L, R);
        if(root.val > R)
            return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] ar)
    {
        BinarySearchTree obj = new BinarySearchTree();
        TreeNode root = obj.makeBST(new int[]{5,3,2,4,7,6,8});
        TreeNode newRoot = new TrimBST().trimBST(root, 3,5);
        System.out.println(obj.inOrder(newRoot));
    }
}
