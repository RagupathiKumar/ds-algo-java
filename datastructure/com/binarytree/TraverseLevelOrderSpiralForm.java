package com.binarytree;

import java.util.Arrays;

public class TraverseLevelOrderSpiralForm {

    private static TreeNode<Integer> root = null;

    public static void main(String[] args) {

        BinaryTreeDemo demo = new BinaryTreeDemo();
        Arrays.asList(1, 2, 3, 7, 6, 5, 4).stream().forEach(demo::insert);
        root = demo.getRoot();

        traverseLevelSpiralForm();
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

    static void traverseLevelSpiralForm() {

        int height = height(root);

        for (int level = 1; level <= height; level++) {
            boolean toggle = (level % 2 == 0);
            traverseLevel(root, level, toggle);
        }

    }

    static void traverseLevel(TreeNode<Integer> node, int level, boolean toggle) {

        if (level == 1) {
            System.out.print(node.val + " ");
            return;
        }

        if (toggle) {
            traverseLevel(node.left, level - 1, toggle);
            traverseLevel(node.right, level - 1, toggle);
        } else {
            traverseLevel(node.right, level - 1, toggle);
            traverseLevel(node.left, level - 1, toggle);
        }

    }

}
