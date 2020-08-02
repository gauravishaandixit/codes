package codes.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    ArrayList<Integer> leftView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
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

    public static void main(String[] ar)
    {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{5,3,2,4,7,6,8});
        System.out.println(new LeftView().leftView(root));
    }
}
