package gcl65.Session11;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth2(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.push(root);

        while (!q.isEmpty()) {
            height++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return height;
    }
}
