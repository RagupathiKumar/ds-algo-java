package leetcode.practice3;

import gcl65.Session11.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1, size = list.size(); i < size; i++) {
            minDiff = Math.min(Math.abs(list.get(i - 1) - list.get(i)), minDiff);
        }
        return minDiff;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }


    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference2(TreeNode root) {
        getMinimumDifference3(root);
        return minDiff;
    }

    public void getMinimumDifference3(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        if (root.left != null) {
            TreeNode prev = root.left;
            while (prev.right != null) {
                prev = prev.right;
            }
            minDiff = Math.min(root.val - prev.val, minDiff);
        }

        if (root.right != null) {
            TreeNode next = root.right;
            while (next.left != null) {
                next = next.left;
            }
            minDiff = Math.min(next.val - root.val, minDiff);
        }

        getMinimumDifference3(root.left);
        getMinimumDifference3(root.right);
    }

}
