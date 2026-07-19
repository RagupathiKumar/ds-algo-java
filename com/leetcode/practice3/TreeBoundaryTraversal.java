package leetcode.practice3;

import gcl65.Session11.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TreeBoundaryTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(8);
//        root.left.right.right = new TreeNode(9);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(new TreeBoundaryTraversal().boundaryTraversal(root));
    }

    public List<Integer> boundaryTraversal(TreeNode root) {
        // code here
        List<Integer> result = new ArrayList<>();
        result.add(root.val);

        List<Integer> left = new ArrayList<>();
        TreeNode node = root.left;
        while (node != null && (node.left != null || node.right != null)) {
            left.add(node.val);
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }

        }

        List<Integer> leaves = new ArrayList<>();
        preOrder(root.left, leaves);
        preOrder(root.right, leaves);

        List<Integer> right = new ArrayList<>();
        TreeNode node1 = root.right;
        while (node1 != null && (node1.left != null || node1.right != null)) {
            right.add(node1.val);
            if (node1.right != null) {
                node1 = node1.right;
            } else {
                node1 = node1.left;
            }
        }
        right.sort(Comparator.reverseOrder());

        result.addAll(left);
        result.addAll(leaves);
        result.addAll(right);
        return result;
    }

    private void preOrder(TreeNode root, List<Integer> leaves) {
        // base case
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }

        // recursive case
        preOrder(root.left, leaves);
        preOrder(root.right, leaves);
    }

}
