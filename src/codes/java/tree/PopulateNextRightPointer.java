package codes.java.tree;


import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {
    class Node
    {
        int val;
        Node left, right, nextRight;
        Node(int val)
        {
            this.val = val;
            this.left = null;
            this.right = null;
            this.nextRight = null;
        }
    }

    void connectNextRight(Node root)
    {
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null;
        while(!q.isEmpty())
        {
            int n = q.size();
            while( n-- > 0)
            {
                temp = q.poll();

                if(n > 0)
                    temp.nextRight = q.peek();

                if(temp.left != null)
                    q.add(temp.left);

                if(temp.right != null)
                    q.add(temp.right);
            }
            temp.nextRight = null;
        }
    }
}
