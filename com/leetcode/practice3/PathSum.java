package leetcode.practice3;

import gcl65.Session11.TreeNode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        // base case
        if (root == null) {
            return false;
        }

        if (sum + root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        // recursive case
        return hasPathSum(root.left, sum + root.val)
                || hasPathSum(root.right, sum + root.val);
    }

}
