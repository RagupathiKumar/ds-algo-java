package com.binarytree;

import java.util.*;

public class ReverseLevelOrderTraversal {

    private static TreeNode<Integer> root = null;

    public static void main(String[] args) {

        BinaryTreeDemo demo = new BinaryTreeDemo();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().forEach(demo::insert);
        root = demo.getRoot();

        reverseLevelOrderTraverseUsingRecursion();
        reverseLevelOrderTraverseUsingQueueAndStack();
    }

    static int height(TreeNode<Integer> node) {

        if (node == null) {
            return 0;
        }

        int lHeight = height(node.left);
        int rHeight = height(node.right);

        if (lHeight > rHeight) {
            return lHeight + 1;
        } else {
            return rHeight + 1;
        }
    }

    static void reverseLevelOrderTraverseUsingRecursion() {

        int height = height(root);

        for (int level = height; level >= 1; level--) {
            traverseLevel(root, level);
        }

        System.out.println("");
    }

    static void traverseLevel(TreeNode<Integer> node, int level) {

        if (level == 1) {
            System.out.print(node.val + " ");
            return;
        }

        traverseLevel(node.left, level - 1);
        traverseLevel(node.right, level - 1);
    }

    static void reverseLevelOrderTraverseUsingQueueAndStack() {

        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        Stack<TreeNode<Integer>> s = new Stack<>();

        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode<Integer> node = q.poll();

            if (node.right != null) {
                q.offer(node.right);
            }

            if (node.left != null) {
                q.offer(node.left);
            }

            s.push(node);
        }

        while (!s.isEmpty()) {
            TreeNode<Integer> node = s.pop();
            System.out.print(node.val + " ");
        }
    }

}
