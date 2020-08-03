package codes.java.tree.construct;

import codes.java.tree.TreeNode;

public class MakeABSTFromSortedArray {

    TreeNode makeBST(int[] arr)
    {
        if(arr.length == 0)
            return null;

        return makeBST(arr, 0, arr.length - 1);
    }

    TreeNode makeBST(int[] arr, int left, int right)
    {
        if(left > right)
            return null;

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = makeBST(arr, left, mid - 1);
        root.right = makeBST(arr, mid + 1, right);
        return root;
    }
}
