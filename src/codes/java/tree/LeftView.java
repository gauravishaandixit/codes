package codes.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    ArrayList<Integer> leftView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 1; i <= size; i++)
            {
                TreeNode curr = q.poll();
                if(i == 1)
                    ans.add(curr.val);

                if(curr.left != null)
                    q.add(curr.left);

                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        return ans;
    }

    ArrayList<Integer> leftViewRecursive(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        int[] maxLevel = {0};

        levelOrderTraversal(root, ans, 1, maxLevel);

        return ans;
    }

    private void levelOrderTraversal(TreeNode root, ArrayList<Integer> ans, int currLevel, int[] maxLevel) {
        if(root == null)
            return;

        if(maxLevel[0] < currLevel) {
            ans.add(root.val);
            maxLevel[0] = currLevel;
        }

        levelOrderTraversal(root.left, ans, currLevel + 1, maxLevel);
        levelOrderTraversal(root.right, ans, currLevel + 1, maxLevel);

    }

    public static void main(String[] ar)
    {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{5,3,2,4,7,6,8});
        System.out.println(new LeftView().leftView(root));
        System.out.println(new LeftView().leftViewRecursive(root));
    }
}
