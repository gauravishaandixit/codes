package codes.java.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Cousins {

    boolean isCousin(TreeNode root, int x, int y)
    {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode xParent = null, yParent = null;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();

            while(size-- > 0)
            {
                TreeNode node = queue.poll();

                if(node.left != null)
                {
                    queue.offer(node.left);

                    if(node.left.val == x)
                        xParent = node;
                    if(node.left.val == y)
                        yParent = node;
                }
                if(node.right != null)
                {
                    queue.offer(node.right);

                    if(node.right.val == x)
                        xParent = node;
                    if(node.right.val == y)
                        yParent = node;
                }
                if(xParent != null && yParent != null)
                    break;
            }

            if(xParent != null && yParent != null)
                return xParent != yParent;

            if((xParent != null && yParent == null) || (xParent == null && yParent != null))
                return false;

        }
        return false;
    }

}
