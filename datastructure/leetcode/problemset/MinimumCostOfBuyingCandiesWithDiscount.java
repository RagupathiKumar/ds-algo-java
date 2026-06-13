package leetcode.problemset;

// https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {

    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{1, 2, 3})); // 5
        System.out.println(minimumCost(new int[]{6, 5, 7, 9, 2, 2})); // 23
        System.out.println(minimumCost(new int[]{5, 5})); // 10
    }

    static int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);

        int minCost = 0;
        for (int i = n - 1; i >= 0; i--) {
            minCost += cost[i--];
            if (i >= 0) {
                minCost += cost[i--];
            }
        }
        return minCost;
    }

}
