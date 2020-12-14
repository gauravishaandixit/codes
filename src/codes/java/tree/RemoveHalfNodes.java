package codes.java.tree;


// https://www.interviewbit.com/problems/remove-half-nodes/
public class RemoveHalfNodes {

    TreeNode removeHalfNodes(TreeNode root)
    {
        if(root.left == null && root.right == null)
            return root;


        if(root.left == null)
            return removeHalfNodes(root.right);

        if(root.right == null)
            return removeHalfNodes(root.left);

        root.left = removeHalfNodes(root.left);
        root.right = removeHalfNodes(root.right);

        return root;
    }



}
