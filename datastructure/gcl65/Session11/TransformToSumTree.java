package gcl65.Session11;

public class TransformToSumTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        new TransformToSumTree().transform(root);
    }

    private int transform(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int temp = root.val;
        root.val = transform(root.left) + transform(root.right);
        return temp + root.val;
    }

}
