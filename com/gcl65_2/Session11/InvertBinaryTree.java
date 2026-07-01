package gcl65_2.Session11;

import gcl65.Session11.TreeNode;

public class InvertBinaryTree {

    // Pre-Order
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return root;
        }

        // recursive case
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    // Pre-Order
    public TreeNode invertTree2(TreeNode root) {
        // base case
        if (root == null) {
            return root;
        }

        // recursive case
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }

    // Post-Order
    public TreeNode invertTree3(TreeNode root) {
        // base case
        if (root == null) {
            return root;
        }

        // recursive case
        invertTree3(root.left);
        invertTree3(root.right);

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        return root;
    }



}
