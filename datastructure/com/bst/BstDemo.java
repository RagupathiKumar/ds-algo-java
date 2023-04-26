package com.bst;

public class BstDemo {

    private static TreeNode<Integer> root = null;

    public static void main(String[] args) {

        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        inOrder(root);
        System.out.println();

        TreeNode<Integer> copy = copy(root);
        inOrder(copy);
        System.out.println();

        System.out.println(root.hashCode());
        System.out.println(copy.hashCode());

        printLeafNodes(root);
        System.out.println();

        printNonLeafNodes(root);
        System.out.println();

        inOrder(copy);
        copy = delete(copy);
        System.out.println();
        inOrder(copy);
        System.out.println();

        printRightView(root);
        System.out.println();
        printLeftView(root);
    }

    static TreeNode<Integer> insert(TreeNode<Integer> node, int value) {

        if (node == null) {
             return new TreeNode<>(value);
        }

        if (value < node.val) {
            node.left = insert(node.left, value);
        } else if (value > node.val) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    static void inOrder(TreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    static TreeNode<Integer> copy(TreeNode<Integer> node) {

        TreeNode<Integer> copy = null;

        if (node != null) {
            copy = new TreeNode<>(node.val);
            copy.left = copy(node.left);
            copy.right = copy(node.right);
        }

        return copy;
    }

    static void printLeafNodes(TreeNode<Integer> node) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.val + " ");
            return;
        }

        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }

    static void printNonLeafNodes(TreeNode<Integer> node) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }

        System.out.print(node.val + " ");
        printNonLeafNodes(node.left);
        printNonLeafNodes (node.right);
    }

    static TreeNode<Integer> delete(TreeNode<Integer> node) {

        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return null;
        }

        if (node.right != null) {
            node.right = delete(node.right);
        } else {
            node.left = delete(node.left);
        }

        return node;
    }

    static void printRightView(TreeNode<Integer> node) {

        if (node == null) {
            System.out.println();
            return;
        }

        System.out.print(node.val + " ");
        printRightView(node.right);
    }

    static void printLeftView(TreeNode<Integer> node) {

        if (node == null) {
            System.out.println();
            return;
        }

        System.out.print(node.val + " ");
        printRightView(node.left);
    }

    static TreeNode<Integer> smallestNode(TreeNode<Integer> root) {

        TreeNode<Integer> current = root;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }


    static TreeNode<Integer> deleteNode(TreeNode<Integer> node)  {
        return null;
    }

}
