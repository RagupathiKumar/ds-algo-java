package leetcode.practice4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumNumberOfPushesToTypeWordII {

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordII prob = new MinimumNumberOfPushesToTypeWordII();
        System.out.println(prob.minimumPushes("abcde")); // 5
        System.out.println(prob.minimumPushes("xyzxyzxyzxyz")); // 12
        System.out.println(prob.minimumPushes("aabbccddeeffgghhiiiiii")); // 24
    }

    class Pair {
        char ch;
        int cnt;
        public Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public int minimumPushes(String word) {
        int n = word.length();
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.cnt - p1.cnt);
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            maxHeap.add(new Pair(e.getKey(), e.getValue()));
        }

        int pushes = 0;
        for (int pos = 1; pos <= 4; pos++) {
            for (int key = 2; key <= 9 && !maxHeap.isEmpty(); key++) {
                pushes += maxHeap.poll().cnt * pos;
            }
        }
        return pushes;
    }

}
