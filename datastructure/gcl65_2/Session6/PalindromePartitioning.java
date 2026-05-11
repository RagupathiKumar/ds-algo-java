package gcl65_2.Session6;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        List<List<String>> results = new PalindromePartitioning().partition("aab");
        for (List<String> result : results) {
            System.out.println(result);
        }
    }

    List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partition(s, 0, s.length(), path, results);
        return results;
    }

    void partition(String s, int i, int n, List<String> path, List<List<String>> results) {
        // base case
        if (i == n) {
            results.add(new ArrayList<>(path));
            return;
        }

        // recursive case
        for (int j = i; j < n; j++) {
            String substring = s.substring(i, j + 1);
            if (palindrome(substring)) {
                path.add(substring);
                partition(s, j + 1, n, path, results);
                path.remove(path.size() - 1); // backtracking
            }
        }
    }

    private boolean palindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }

}
