package com.binarytree;

import java.util.Arrays;

public class ReverseLevelOrderTraversal {

    private static TreeNode<Integer> root = null;

    public static void main(String[] args) {

        BinaryTreeDemo demo = new BinaryTreeDemo();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().forEach(demo::insert);
        root = demo.getRoot();

        reverseLevelOrderTraverseUsingRecursion();
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

    }

}
