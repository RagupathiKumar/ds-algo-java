package gcl65.Session6;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithSum0 {

    public static void main(String[] args) {
        System.out.println(sumZero(new int[] {4, 2, 1, -3, 6}));
        System.out.println(sumZero(new int[] {0}));
        System.out.println(sumZero(new int[] {1, -1}));
    }

    private static boolean sumZero(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum == 0 || set.contains(prefixSum)) {
                return true;
            }
            set.add(prefixSum);
        }
        return false;
    }

}
