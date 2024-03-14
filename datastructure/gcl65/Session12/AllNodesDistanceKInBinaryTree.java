package gcl65.Session12;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    // self implementation -- did not cover all case -- leetcode submission failed -- START
    class Pair {
        TreeNode node;
        int hd;
        public Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // STEP 1
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int hd = p.hd;
            map.put(node.val, hd);

            if (node.val == target.val) {
                hd = 1 - hd;
            } else {
                hd += 1;
            }

            if (node.left != null) {
                q.add(new Pair(node.left, hd));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd));
            }
        }

        // STEP 2
        int dist = map.get(target.val);
        for (Integer key : map.keySet()) {
            map.put(key, map.get(key) + dist);
        }
        map.put(target.val, 0);

        // STEP 3
        for (Integer key : map.keySet()) {
            if (map.get(key) == k) {
                res.add(key);
            }
        }

        return res;
    }
    // self implementation -- END

    // Chaman's approach, Self implementation -- START
    public List<Integer> distanceKChaman(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        Set<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.add(target);

        for (int i = 0; i < k; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = q.poll();
                visited.add(node);

                if (node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                }
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    q.add(parentMap.get(node));
                }
            }
        }

        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }

    private void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        if (root.left != null) {
            parentMap.put(root.left, root);
            buildParentMap(root.left, parentMap);
        }

        if (root.right != null) {
            parentMap.put(root.right, root);
            buildParentMap(root.right, parentMap);
        }
    }
    // Chaman's approach, Self implementation -- END

}
