package codes.java.tree;


import java.util.ArrayList;

// https://leetcode.com/problems/boundary-of-binary-tree/
public class BoundaryTraversal {

    ArrayList<Integer> boundaryTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.val);

        getLeftBoundary(root.left, ans);
        getLeavesBoundary(root.left, ans);
        getRightBoundary(root.right, ans);

        return ans;
    }

    private void getRightBoundary(TreeNode root, ArrayList<Integer> ans) {
    }

    private void getLeavesBoundary(TreeNode root, ArrayList<Integer> ans) {
    }

    private void getLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
    }

}
