package gcl65.Session15;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[] {1, 2, 5, 10, 20, 50}, 37));
        System.out.println(new CoinChange().coinChange(new int[] {1, 7, 10}, 15)); // since we used Greedy approach, this result is not right
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

}