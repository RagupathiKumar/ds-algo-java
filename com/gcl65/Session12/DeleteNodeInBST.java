package gcl65.Session12;

public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode leftMostNode = findLeftMostNode(root.right);
                root.right = deleteNode(root.right, leftMostNode.val);
                root.val = leftMostNode.val;
            }
        }
        return root;
    }

    private TreeNode findLeftMostNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
