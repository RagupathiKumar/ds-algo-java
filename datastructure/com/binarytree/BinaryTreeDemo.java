package com.binarytree;

import java.util.*;

public class BinaryTreeDemo {


    private TreeNode<Integer> root = null;

    public TreeNode<Integer> getRoot() { return root; }

    public static void main(String[] args) {

        BinaryTreeDemo demo = new BinaryTreeDemo();

//        TreeNode<Integer> root = new TreeNode<>(1);
//        root.left = new TreeNode<>(2);
//        root.right = new TreeNode<>(3);
//        root.left.left = new TreeNode<>(4);
//        root.left.right = new TreeNode<>(5);
//        root.right.left = new TreeNode<>(6);
//        root.right.right = new TreeNode<>(7);

//        levelOrderTraverse(root);

        Arrays.asList(1, 2, 3, 4, 5).stream().forEach(demo::insert);

//        insert(1);
//        insert(2);
//        insert(3);
//        insert(4);
//        insert(root, 1);
        demo.levelOrderTraverse();
//        levelOrderTraverse(root);
    }

    public void levelOrderTraverse() {
//    public static void levelOrderTraverse(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            TreeNode<Integer> node = q.remove();
            System.out.print(node.val + " ");

            if (node.left != null) {
                q.add(node.left);
            }

            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    public void insert(Integer val) {
//    public static void insert(TreeNode<Integer> root, Integer val) {

        TreeNode<Integer> newNode = new TreeNode<>(val);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            TreeNode<Integer> node = q.remove();

            if (node.left == null) {
                node.left = newNode;
                break;
            } else {
                q.add(node.left);
            }

            if (node.right == null) {
                node.right = newNode;
                break;
            } else {
                q.add(node.right);
            }
        }

    }

}
