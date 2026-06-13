package leetcode.problemset;

// https://leetcode.com/problems/destroying-asteroids/

import java.util.Arrays;

public class DestroyingAsteroids {

    public static void main(String[] args) {
        System.out.println(asteroidsDestroyed2(10, new int[]{3, 9, 19, 5, 21})); // true
        System.out.println(asteroidsDestroyed2(5, new int[]{4, 9, 23, 4})); // false
        System.out.println(asteroidsDestroyed2(86, new int[]{156, 197, 192, 14, 97, 160, 14, 5})); // true
        System.out.println(asteroidsDestroyed2(5, new int[]{40, 40, 10, 40, 40, 5, 40, 20})); // true
    }

    static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (m < asteroids[i]) {
                return false;
            }
            m += asteroids[i];
        }
        return true;
    }

    static boolean asteroidsDestroyed2(int mass, int[] asteroids) {
        int n = asteroids.length;
        int s = 0, e = n - 1;
        long oldMass = mass;
        long newMass = mass;

        while (s < n) {
            while (s <= e) {
                if (asteroids[s] <= newMass) {
                    newMass += asteroids[s];
                    s++;
                } else if (asteroids[e] > newMass) {
                    e--;
                } else {
                    int t = asteroids[s];
                    asteroids[s] = asteroids[e];
                    asteroids[e] = t;
                }
            }

            if (newMass > oldMass) {
                oldMass = newMass;
                e = n - 1;
            } else {
                return false;
            }
        }

        return true;
    }

}
