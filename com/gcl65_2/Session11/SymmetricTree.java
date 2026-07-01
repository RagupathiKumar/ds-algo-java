package gcl65_2.Session11;

import gcl65.Session11.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.val != 1000) {
                    q.add((node.left != null) ? node.left : new TreeNode(1000));
                    q.add((node.right != null) ? node.right : new TreeNode(1000));
                }
            }
            int s = 0, e = level.size() - 1;
            while (s < e) {
                if (!level.get(s).equals(level.get(e))) {
                    return false;
                }
                s++;
                e--;
            }
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // base case
        if (left == null || right == null) {
            return left == right;
        }

        // recursive case
        return (left.val == right.val)
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

}
