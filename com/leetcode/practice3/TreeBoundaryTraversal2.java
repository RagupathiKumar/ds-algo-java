package leetcode.practice3;

import gcl65.Session11.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TreeBoundaryTraversal2 {

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

        System.out.println(new TreeBoundaryTraversal2().boundaryTraversal(root));
    }

    private List<Integer> result = new ArrayList<>();

    public List<Integer> boundaryTraversal(TreeNode root) {
        // code here
        result.add(root.val);

        TreeNode node = root.left;
        while (node != null && (node.left != null || node.right != null)) {
            result.add(node.val);
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }

        }

        preOrder(root.left);
        preOrder(root.right);

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

        result.addAll(right);
        return result;
    }

    private void preOrder(TreeNode root) {
        // base case
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }

        // recursive case
        preOrder(root.left);
        preOrder(root.right);
    }

}
