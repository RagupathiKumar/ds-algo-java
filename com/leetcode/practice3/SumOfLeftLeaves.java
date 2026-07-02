package leetcode.practice3;

import gcl65.Session11.TreeNode;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int val = 0;
        TreeNode left = root.left;
        if (left != null && left.left == null && left.right == null) {
            val = left.val;
        }

        return val + sumOfLeftLeaves(left) + sumOfLeftLeaves(root.right);
    }

}
