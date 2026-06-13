package leetcode.problemset;

// https://leetcode.com/problems/weighted-word-mapping/description/

public class WeightedWordMapping {

    public static void main(String[] args) {
        System.out.println(
                mapWordWeights(
                        new String[]{"abcd", "def", "xyz"},
                        new int[]{5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2})
        ); // rij
    }

    static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int weight = 0;
            for (int j = 0, n = words[i].length(); j < n; j++) {
                weight += weights[words[i].charAt(j) - 'a'];
            }
            sb.append((char) ('z' - (weight % 26)));
        }
        return sb.toString();
    }

}
