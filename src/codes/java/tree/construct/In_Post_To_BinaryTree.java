package codes.java.tree.construct;

import codes.java.tree.TreeNode;

import java.util.HashMap;

public class In_Post_To_BinaryTree {

    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] in, int[] post) {
        map = new HashMap<>();
        int i = 0;
        for(int n: in)
            map.put(n, i++);

        return treeBuilder(in, 0 , in.length - 1, post, post.length - 1);
    }

    TreeNode treeBuilder(int[] in, int inStart, int inEnd, int[] post, int postEnd)
    {
        if(postEnd < 0 || inStart > inEnd)
            return null;


        TreeNode root = new TreeNode(post[postEnd]);
        int index = map.get(root.val);


        root.left = treeBuilder(in, inStart, index - 1, post, postEnd - (inEnd - index + 1));
        root.right = treeBuilder(in,index + 1, inEnd, post, postEnd - 1);

        return root;
    }

}
