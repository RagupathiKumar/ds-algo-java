package gcl65_2.Session12;

import gcl65.Session11.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        // base case
        if (root == null) {
            return true;
        }

        // recursive case
        return (min <= root.val && root.val <= max)
                && isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

}
