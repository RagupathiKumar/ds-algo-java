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

}
