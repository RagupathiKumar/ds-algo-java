package gcl65_2.Session11;

import gcl65.Session11.TreeNode;

// https://www.geeksforgeeks.org/problems/transform-to-sum-tree/1
public class TransformToSumTree {

    public void toSumTree(TreeNode root) {
        toSumSubTree(root);
    }

    public int toSumSubTree(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int val = root.val;
        int left = toSumSubTree(root.left);
        int right = toSumSubTree(root.right);
        root.val = left + right;
        return val + root.val;
    }

}
