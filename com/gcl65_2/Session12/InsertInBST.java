package gcl65_2.Session12;

import gcl65.Session11.TreeNode;

public class InsertInBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // base case
        if (root == null) {
            return new TreeNode(val);
        }

        // recursive case
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}
