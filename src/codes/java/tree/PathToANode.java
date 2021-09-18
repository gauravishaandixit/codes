package codes.java.tree;


import java.util.ArrayList;

public class PathToANode {
    ArrayList<Integer> ans = new ArrayList<>();
    void pathToNode(TreeNode root, int node) {
        findPath(root, node, new ArrayList<>());
        System.out.println(ans);
    }

    void findPath(TreeNode root, int node, ArrayList<Integer> curr) {
        if(root == null)
            return;

        curr.add(root.val);
        if(root.val == node)
            ans = new ArrayList<>(curr);
        else {
            findPath(root.left, node, curr);
            findPath(root.right, node, curr);
        }
        curr.remove(curr.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new BinarySearchTree().makeBST(new int[]{9, 4, 7, 1, 10, 15, 11, 23, 45, 99, 46, 22, 12, 90});
        new PathToANode().pathToNode(root, 22);
        new PathToANode().pathToNode(root, 2);
        new PathToANode().pathToNode(root, 11);
    }
}
