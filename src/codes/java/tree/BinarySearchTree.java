package codes.java.tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree {

    TreeNode makeBST(int[] arr)
    {
        TreeNode root = null;
        for(int i = 0; i < arr.length; i++)
            root = insert(root, arr[i]);

        System.out.println(preOrder(root));
        System.out.println(inOrder(root));
        System.out.println(postOrder(root));
        return root;
    }
    TreeNode insert(TreeNode root, int key)
    {
        if(root == null)
        {
            root = new TreeNode(key);
        }
        if(root.val < key)
            root.right = insert(root.right, key);
        else
        {
            if(root.val > key)
                root.left = insert(root.left, key);
        }
        return root;
    }
    TreeNode deleteNode(TreeNode root, int key)
    {
        if (root == null)
            return root;

        if(key < root.val)
            root.left = deleteNode(root.left , key);
        else
        {
            if(key > root.val)
                root.right = deleteNode(root.right, key);
            else
            {
                if(root.left == null)
                    return root.right;
                else
                {
                    if(root.right == null)
                        return root.left;
                }

                root.val = minValueInRightSubtree(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    int minValueInRightSubtree(TreeNode root)
    {
        while(root.left != null)
            root = root.left;

        return root.val;
    }
    ArrayList<Integer> inOrder(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !st.isEmpty())
        {
            while(curr != null)
            {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }

    ArrayList<Integer> preOrder(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        st.push(curr);

        while(!st.isEmpty())
        {
            curr = st.pop();
            ans.add(curr.val);

            if(curr.right != null)
                st.push(curr.right);
            if(curr.left != null)
                st.push(curr.left);
        }
        return ans;
    }

    ArrayList<Integer> postOrder(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        st.push(curr);
        while(!st.isEmpty())
        {
            curr = st.pop();
            ans.add(0, curr.val);
            if(curr.left != null)
                st.push(curr.left);

            if(curr.right != null)
                st.push(curr.right);
        }
        return ans;
    }
    public static void main(String[] ar)
    {
        BinarySearchTree obj = new BinarySearchTree();
        TreeNode root = obj.makeBST(new int[]{5,3,2,4,7,6,8});

        root = obj.deleteNode(root, 5);
        System.out.println(obj.inOrder(root));
    }
}
