package codes.java.tree;

public class TreeLeavesToDLL {

    TreeNode head = null, last = null;
    TreeNode convertToDLL(TreeNode root)
    {
        helper(root);
        return head;
    }

    private void helper(TreeNode root)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            if(head == null)
            {
                head = root;
                last = root;
            }
            else
            {
                last.right = root;
                root.left = last;
                last = root;
            }
            return;
        }
        helper(root.left);
        helper(root.right);
    }
    static void printDLL(TreeNode head)
    {
        while(head != null)
        {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.print("\n");
    }
    public static void main(String[] arg)
    {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{5,3,2,4,7,6,8});
        TreeNode head = new TreeLeavesToDLL().convertToDLL(root);
        printDLL(head);
    }
}
