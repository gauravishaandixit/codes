package codes.java.tree.construct;

import codes.java.tree.TreeNode;

import java.util.HashMap;

public class In_Post_To_BinaryTree {

    public TreeNode buildTree(int[] in, int[] post) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        int i = 0;
        for(int n: in)
            inMap.put(n, i++);

        return treeBuilder(inMap, 0 , in.length - 1, post, post.length - 1);
    }

    TreeNode treeBuilder(HashMap<Integer, Integer> inMap, int inStart, int inEnd, int[] post, int postEnd)
    {
        if(postEnd < 0 || inStart > inEnd)
            return null;


        TreeNode root = new TreeNode(post[postEnd]);
        int index = inMap.get(root.val);
        int nodesOnRight = inEnd - index;

        root.left = treeBuilder(inMap, inStart, index - 1, post, postEnd - nodesOnRight - 1);
        root.right = treeBuilder(inMap,index + 1, inEnd, post, postEnd - 1);

        return root;
    }

}
