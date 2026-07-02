package leetcode.practice3;

import gcl65.Session11.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);

        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(6);

        root.right.right = new TreeNode(-1);
        root.right.right.right = new TreeNode(8);

        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            reverse = !reverse;
            if (reverse) {
                reverse(level);
            }
            levels.add(level);
        }

        return levels;
    }

    private void reverse(List<Integer> level) {
        int s = 0, e = level.size() - 1;
        while (s < e) {
            int temp = level.get(s);
            level.set(s++, level.get(e));
            level.set(e--, temp);
        }
    }

}
