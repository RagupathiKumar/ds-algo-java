package leetcode.practice4;

public class MinimumNumberOfPushesToTypeWordI {

    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0, pos = 1;
        while (n >= 8) {
            pushes += pos * 8;
            n -= 8;
            pos++;
        }
        pushes += pos * n;
        return pushes;
    }

}