package gcl65_2.Session11;

import gcl65.Session11.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
