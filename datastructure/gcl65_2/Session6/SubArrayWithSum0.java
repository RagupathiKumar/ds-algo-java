package gcl65_2.Session6;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithSum0 {

    public static void main(String[] args) {
        System.out.println(findsum(new int[]{4, 2, -3, 1, 6}));
        System.out.println(findsum(new int[]{4, 2, 0, 1, 6}));
        System.out.println(findsum(new int[]{1, 2, -1}));
        System.out.println(findsum(new int[]{1, 2, -1, 0}));
    }

    static boolean findsum(int arr[]) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

}
