package codes.java.tree.construct;

import codes.java.tree.TreeNode;

public class Pre_In_To_BinaryTree {

    TreeNode buildTree(int[] pre, int[] in) {
        return treeBuilder(pre , 0 , in, 0 , in.length - 1);
    }

    TreeNode treeBuilder(int[] pre, int preStart, int[] in, int inStart, int inEnd)
    {
        if(preStart > pre.length || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(pre[preStart]);

        int inIndex = 0;

        for(int i = inStart; i <= inEnd;i++)
        {
            if(in[i] == root.val)
            {
                inIndex = i;
                break;
            }
        }

        root.left = treeBuilder(pre, preStart + 1, in, inStart, inIndex-1);
        root.right = treeBuilder(pre, preStart + inIndex + 1- inStart , in, inIndex + 1, inEnd);

        return root;
    }

}
