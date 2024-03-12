package gcl65.Session12;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(2); // ans should be 20


        BinaryTreeMaximumPathSum sum = new BinaryTreeMaximumPathSum();
        sum.maxPathSum(root);
        System.out.println(sum.max);
    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // max(root);
        maxSelf(root);
        return max;
    }

    // post-order traversal - Chaman's impl
    private int max(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int leftSum = Math.max(max(root.left), 0);
        int rightSum = Math.max(max(root.right), 0);

        max = Math.max(root.val + leftSum + rightSum, max);

        return root.val + Math.max(leftSum, rightSum);
    }

    // post-order traversal - Self impl
    private int maxSelf(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int leftSum = maxSelf(root.left);
        int rightSum = maxSelf(root.right);

        int currSum = root.val + leftSum + rightSum;
        max = Math.max(currSum, max);

        int pathSum = root.val + Math.max(leftSum, rightSum);
        return pathSum < 0 ? 0 : pathSum; // do not return negative value
    }

}
