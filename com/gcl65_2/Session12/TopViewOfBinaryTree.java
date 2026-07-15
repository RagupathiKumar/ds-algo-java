package gcl65_2.Session12;

import gcl65.Session11.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

// https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewOfBinaryTree {

    private class Pair {
        TreeNode node;
        int hd;  // horizontal distance
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

     public ArrayList<Integer> topView(TreeNode root) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;

            if (map.get(hd) == null) {
                map.put(hd, node.val);
            }

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }
        return new ArrayList<>(map.values());
    }

}
