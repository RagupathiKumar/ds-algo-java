package gcl65_2.Session12;

import gcl65.Session11.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(new AllNodesDistanceKInBinaryTree().distanceK(root, root.left, 2));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeNode> childToParentMap = new HashMap<>();
        populate(root, childToParentMap);

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int dist = 0;
        while (!q.isEmpty() && dist <= k) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                visited.add(node.val);

                if (dist == k) {
                    result.add(node.val);
                }

                TreeNode left = node.left;
                if (left != null && !visited.contains(left.val)) {
                    q.add(node.left);
                }

                TreeNode right = node.right;
                if (right != null && !visited.contains(right.val)) {
                    q.add(node.right);
                }

                TreeNode parent = childToParentMap.get(node.val);
                if (parent != null && !visited.contains(parent.val)) {
                    q.add(parent);
                }
            }
            dist++;
        }

        return result;
    }

    private void populate(TreeNode root, Map<Integer, TreeNode> childToParentMap) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        if (root.left != null) {
            childToParentMap.put(root.left.val, root);
            populate(root.left, childToParentMap);
        }

        if (root.right != null) {
            childToParentMap.put(root.right.val, root);
            populate(root.right, childToParentMap);
        }
    }

}
