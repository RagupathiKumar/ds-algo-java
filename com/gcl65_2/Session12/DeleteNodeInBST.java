package gcl65_2.Session12;

import gcl65.Session11.TreeNode;

public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        // base case
        if (root == null) {
            return root;
        }

        // recursive case
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode node = rightMostNode(root.left);
                root.left = deleteNode(root.left, node.val);
                root.val = node.val;
            }
        }

        return root;
    }

    private TreeNode rightMostNode(TreeNode root) {
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

}
