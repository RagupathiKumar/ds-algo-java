package leetcode.LeetCode75;

import gcl65.Session11.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(200);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(200);

        System.out.println(new LeafSimilarTrees().leafSimilar(root, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        preOrder(root1, leaves1);

        List<Integer> leaves2 = new ArrayList<>();
        preOrder(root2, leaves2);

        if (leaves1.size() != leaves2.size()) {
            return false;
        }
        for (int i = 0, n = leaves1.size(); i < n; i++) {
            if (!leaves1.get(i).equals(leaves2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void preOrder(TreeNode root, List<Integer> leaves) {
        // base case
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }

        // recursive case
        if (root.left != null) {
            preOrder(root.left, leaves);
        }
        if (root.right != null) {
            preOrder(root.right, leaves);
        }
    }

}
