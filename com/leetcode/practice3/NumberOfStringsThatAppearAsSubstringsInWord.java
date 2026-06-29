package leetcode.practice3;

public class NumberOfStringsThatAppearAsSubstringsInWord {

    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;
        for (int i = 0; i < patterns.length; i++) {
            cnt += word.indexOf(patterns[i]) != -1 ? 1 : 0;
        }
        return cnt;
    }

}
