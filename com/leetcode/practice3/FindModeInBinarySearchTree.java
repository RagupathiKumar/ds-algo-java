package leetcode.practice3;

import gcl65.Session11.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree {

    private int max = Integer.MIN_VALUE;
    private int noOfModes = 0;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> freq = new HashMap<>();
        findMode(root, freq);

        int[] arr = new int[noOfModes];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == max) {
                arr[i++] = entry.getKey();
            }
        }
        return arr;
    }

    private void findMode(TreeNode root, Map<Integer, Integer> freq) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        int cnt = freq.getOrDefault(root.val, 0) + 1;
        freq.put(root.val, cnt);
        if (cnt > max) {
            max = cnt;
            noOfModes = 1;
        } else if (cnt == max) {
            noOfModes++;
        }

        findMode(root.left, freq);
        findMode(root.right, freq);
    }

}
