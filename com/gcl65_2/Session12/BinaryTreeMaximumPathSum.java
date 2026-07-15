package gcl65_2.Session12;

import gcl65.Session11.TreeNode;

public class BinaryTreeMaximumPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxSum;
    }

    public int maxPath(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);
        maxSum = Math.max(root.val + left + right, maxSum);
        if (left > right) {
            return root.val + left;
        } else {
            return root.val + right;
        }
    }

}
