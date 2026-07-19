package leetcode.practice3;

import gcl65.Session11.TreeNode;

import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {

    private Map<Integer, TreeNode> parentChildMap = new HashMap<>();
    private TreeNode startNode;

    public int amountOfTime(TreeNode root, int start) {
        childToParent(root, start);

        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(startNode);

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                TreeNode left = node.left;
                if (left != null && !visited.contains(left.val)) {
                    q.add(left);
                }

                TreeNode right = node.right;
                if (right != null && !visited.contains(right.val)) {
                    q.add(right);
                }

                TreeNode parent = parentChildMap.get(node.val);
                if (parent != null && !visited.contains(parent.val)) {
                    q.add(parent);
                }

                visited.add(node.val);
            }
            if (!q.isEmpty()) {
                time++;
            }
        }
        return time;
    }

    private void childToParent(TreeNode root, int start) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        if (root.val == start) {
            startNode = root;
        }
        if (root.left != null) {
            parentChildMap.put(root.left.val, root);
        }
        if (root.right != null) {
            parentChildMap.put(root.right.val, root);
        }

        childToParent(root.left, start);
        childToParent(root.right, start);
    }

}
