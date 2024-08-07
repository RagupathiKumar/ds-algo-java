package gcl65.Session16;

public class ZeroOneKnapsack {

    public static void main(String[] args) {
        ZeroOneKnapsack knapsack = new ZeroOneKnapsack();
        System.out.println(knapsack.maxValue(5, new int[]{1, 2, 4, 5}, new int[]{5, 4, 8, 6}));
        System.out.println(knapsack.maxValue(5, new int[]{6, 7, 8, 9}, new int[]{5, 4, 8, 6}));
    }


    private int maxValue(int W, int[] w, int[] v) {
        return maxValue(W, w, v, 0, 0, 0);
    }

    private int maxValue(int W, int[] w, int[] v, int i, int totalWeight, int totalValue) {
        // base case
        if (i >= w.length) {
            return totalWeight <= W ? totalValue : -1;
        }

        // recursive case
        // include
        int max1 = maxValue(W, w, v, i + 1, totalWeight + w[i], totalValue + v[i]);

        // exclude
        int max2 = maxValue(W, w, v, i + 1, totalWeight, totalValue);

        return Math.max(max1, max2);
    }

}