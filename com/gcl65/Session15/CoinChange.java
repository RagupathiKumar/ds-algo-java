package gcl65.Session15;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[] {1, 2, 5, 10, 20, 50}, 37));
        System.out.println(new CoinChange().coinChange(new int[] {1}, 0));
        System.out.println(new CoinChange().coinChange(new int[] {1, 7, 10}, 15)); // since we used Greedy approach, this result is not right

        System.out.println();
        System.out.println(new CoinChange().coinChangeDpTopDown(new int[] {1, 7, 10}, 15));
        System.out.println(new CoinChange().coinChangeDpTopDown(new int[] {3}, 2));
        System.out.println(new CoinChange().coinChangeDpTopDown(new int[] {2}, 3));
    }

    public int coinChange(int[] coins, int amount) {
        int cnt  = 0;
        int i = coins.length - 1;

        while (amount > 0) {
            while (coins[i] > amount) {
                i--;
            }
            amount -= coins[i];
            cnt++;
        }

        return cnt;
    }

    // TODO :: try solving it using DP TopDown and BottomUp
    public int coinChangeDpTopDown(int[] coins, int amount) {
        Map<Integer, Integer> amtToCoinMap = new HashMap<>() {{
            put(0, 0);
        }};

        return coinChangeDpTopDown(coins, amount, amtToCoinMap);
    }

    public int coinChangeDpTopDown(int[] coins, int amount, Map<Integer, Integer> amtToCoinMap) {
        // base case
        if (amtToCoinMap.containsKey(amount)) {
            return amtToCoinMap.get(amount);
        }

        // recursive case
        int cnt  = Integer.MAX_VALUE;
        for (int c : coins) {
            if (c > amount) {
                continue;
            }

            int minCoinsRequired = coinChangeDpTopDown(coins, amount - c);
            if (minCoinsRequired == -1) {
                break;
            }

            cnt = Math.min(minCoinsRequired + 1, cnt);
        }
        cnt = (cnt == Integer.MAX_VALUE ? -1 : cnt);

        amtToCoinMap.put(amount, cnt);
        return cnt;
    }

}