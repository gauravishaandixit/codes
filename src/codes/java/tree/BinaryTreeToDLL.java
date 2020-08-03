package codes.java.tree;

public class BinaryTreeToDLL {

    //Inorder

    TreeNode prev = null, head = null;
    void binaryToDLL(TreeNode root)
    {
        if(root == null)
            return;

        binaryToDLL(root.left);
        if(prev == null)
            head = root;
        else
        {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        binaryToDLL(root.right);
    }
    static void printList(TreeNode head)
    {
        while(head != null)
        {
            System.out.print(head.val+" ");
            head = head.right;
        }
        System.out.print("\n");
    }
    public static void main(String[] ar)
    {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{5,3,2,4,7,6,8});
        BinaryTreeToDLL obj = new BinaryTreeToDLL();
        obj.binaryToDLL(root);
        printList(obj.head);
    }
}
