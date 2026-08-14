package leetcode.practice4;

import java.util.HashMap;
import java.util.Map;

public class PredictTheWinner { // Not Solved

    public static void main(String[] args) {
//        System.out.println(predictTheWinner(new int[]{1, 5, 2})); // false
//        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7})); // true
        System.out.println(predictTheWinner(new int[]{1000, 999, 999, 1000, 555, 400})); // true
    }

    static boolean predictTheWinner(int[] nums) {
        int i = 0, j = nums.length - 1;
        Map<Integer, Integer> players = new HashMap<>();
        players.put(1, 0);
        players.put(-1, 0);
        int player = 1;
        while (i <= j) {
            int i1 = nums[i], i2 = (i + 1 < j) ? nums[i + 1] : -1;
            int j1 = nums[j], j2 = (j - 1 > i) ? nums[j - 1] : -1;
            if (i1 >= i2 && i1 >= j1 && i1 >= j2) {
                players.put(player, players.get(player) + nums[i++]);
            } else if (j1 >= i1 && j1 >= i2 && j1 >= j2) {
                players.put(player, players.get(player) + nums[j--]);
            } else if (i2 >= i1 && i2 >= j1 && i2 >= j2) {
                players.put(player, players.get(player) + nums[j--]);
            } else {
                players.put(player, players.get(player) + nums[i++]);
            }
            player = -player;
        }
        return players.get(1) >= players.get(-1);
    }

}
