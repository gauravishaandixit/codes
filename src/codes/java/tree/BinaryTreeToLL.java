package codes.java.tree;


import java.util.Stack;

public class BinaryTreeToLL {

// In preorder fashion

    TreeNode binaryTreeToLL(TreeNode root)
    {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        st.push(curr);
        while(!st.isEmpty())
        {
            curr = st.pop();
            if(curr.right != null)
                st.push(curr.right);

            if(curr.left != null)
                st.push(curr.left);

            if(!st.isEmpty())
                curr.right = st.peek();
            curr.left = null;
        }
        return root;
    }

    static  void printList(TreeNode head)
    {
        while(head != null)
        {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.print("\n");
    }
    public static void main(String[] ar)
    {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{5,3,2,4,7,6,8});
        root = new BinaryTreeToLL().binaryTreeToLL(root);
        printList(root);
    }
}
