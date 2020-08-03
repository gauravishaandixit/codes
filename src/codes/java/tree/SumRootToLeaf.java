package codes.java.tree;

public class SumRootToLeaf {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        sum = 0;
        DFS(root, 0);
        return sum;
    }
    void DFS(TreeNode root, int currSum)
    {
        if(root == null)
            return;

        if(root.left == null && root.right == null)
        {
            currSum = currSum * 10 + root.val;
            sum += currSum;
            return;
        }

        currSum = currSum * 10 + root.val;

        DFS(root.left, currSum);
        DFS(root.right, currSum);
    }
}
