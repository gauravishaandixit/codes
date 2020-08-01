package codes.java.tree;

public class RecoverBST {
    TreeNode first, second, prevNode;
    void recoverBST(TreeNode root)
    {
        first = null;
        second = null;
        prevNode = null;

        inOrder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inOrder(TreeNode root)
    {
        if(root == null)
            return;
        inOrder(root.left);
        if(prevNode != null)
        {
            if(prevNode.val > root.val)
            {
                if(first == null)
                    first = prevNode;
                second = root;
            }
        }
        prevNode = root;
        inOrder(root.right);
    }
}
