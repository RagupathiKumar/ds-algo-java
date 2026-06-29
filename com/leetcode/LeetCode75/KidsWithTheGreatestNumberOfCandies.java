package leetcode.LeetCode75;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[] {2,3,5,1,3}, 3)); // [true,true,true,false,true]
    }

    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;

        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(candies[i - 1], left[i - 1]);
        }

        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(candies[i + 1], right[i + 1]);
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int c = candies[i] + extraCandies;
            result.add(c >= left[i] && c >= right[i]);
        }
        return result;
    }


}
