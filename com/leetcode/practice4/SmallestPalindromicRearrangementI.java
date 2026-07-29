package leetcode.practice4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestPalindromicRearrangementI { // NOT SOLVED YET

    public static void main(String[] args) {
        System.out.println(smallestPalindrome("z")); // z
        System.out.println(smallestPalindrome("babab")); // abbba
        System.out.println(smallestPalindrome("daccad")); // acddca
        System.out.println(smallestPalindrome("yey")); // yey
    }

    static String smallestPalindrome(String s) {
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        char ch = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            ch ^= s.charAt(i);
            maxHeap.add(s.charAt(i));
        }

        StringBuilder b = new StringBuilder();
        if (maxHeap.size() % 2 != 0) {
            b.append(maxHeap.poll());
        }
        while (!maxHeap.isEmpty()) {
            b.insert(0, maxHeap.poll());
            b.append(maxHeap.poll());
        }
        return b.toString();
    }

}
