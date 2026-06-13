package gcl65.Session11;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new SymmetricTree().isSymmetricIterative(root));
    }

    // recursive approach -- start
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // base case
        if (left == null || right == null) {
            return left == right;
        }

        // recursive case
        return (left.val == right.val) &&
                isSymmetric(left.left, right.right) &&
                isSymmetric(left.right, right.left);
    }
    // recursive approach -- end

    // iterative approach -- start
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int n = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.val == 1000) {
                    continue;
                }

                if (node.left != null) {
                    q.add(node.left);
                } else {
                    q.add(new TreeNode(1000));
                }

                if (node.right != null) {
                    q.add(node.right);
                } else {
                    q.add(new TreeNode(1000));
                }
            }

            int i = 0, j = level.size() - 1;
            while (i < j) {
                if (level.get(i).intValue() != level.get(j).intValue()) {
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }
    // iterative approach -- end

}