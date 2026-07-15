package gcl65_2.Session12;

import gcl65.Session11.TreeNode;

public class KthSmallestElementInBST {

    private int kth;

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        return kthSmallest(root);
    }

    private int kthSmallest(TreeNode root) {
        // base case
        if (root == null) {
            return -1;
        }

        // recursive case
        int left = kthSmallest(root.left);
        if (left != -1) {
            return left;
        }

        kth--;
        if (kth == 0) {
            return root.val;
        }

        return kthSmallest(root.right);
    }

}
