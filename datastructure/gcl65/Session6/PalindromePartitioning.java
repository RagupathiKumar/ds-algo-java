package gcl65.Session6;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        partition("aab", 0, path, result);

        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    private static void partition(String s, int i, List<String> path, List<List<String>> result) {

        // base case
        if (i == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // recursive case
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s.substring(i, j + 1))) {
                path.add(s.substring(i, j + 1));
                partition(s, j + 1, path, result);
                path.remove(path.size() - 1); // backtracking
            }
        }

    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
