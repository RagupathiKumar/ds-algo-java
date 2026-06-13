package leetcode.problemset;

// https://leetcode.com/problems/jump-game-iv/

public class JumpGameIV {

    public static void main(String[] args) {
//        System.out.println(minJumps(new int[]{7})); // 0
//        System.out.println(minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404})); // 3
//        System.out.println(minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7})); // 1
        System.out.println(minJumps2(new int[]{7, 7, 2, 1, 7, 7, 7, 3, 4, 1})); // 3
//        System.out.println(minJumps(new int[]{68, -94, -44, -18, -1, 18, -87, 29, -6, -87, -27, 37, -57, 7, 18, 68, -59, 29,
//                7, 53, -27, -59, 18, -1, 18, -18, -59, -1, -18, -84, -20, 7, 7, -87, -18, -84, -20, -27})); // 5
    }

    static int minJumps(int[] arr) {
        int n = arr.length;

        int[] dynArr = new int[n];
        dynArr[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            dynArr[i] = dynArr[i + 1] + 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    dynArr[i] = Math.min(dynArr[i], dynArr[j] + 1);
                }
            }
        }

        for (int i = n - 2; i >= 1; i--) {
            if (dynArr[i - 1] < dynArr[i]) {
                dynArr[i] = dynArr[i - 1] + 1;
            }
        }

        for (int i = 1; i < n; i++) {
            if (arr[0] == arr[i] && dynArr[0] > dynArr[i]) {
                dynArr[0] = dynArr[i] + 1;
            }
        }

        return dynArr[0];
    }

    static int minJumps2(int[] arr) {
        int n = arr.length;

        int[] rightArr = new int[n];
        rightArr[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i + 1] + 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j] && rightArr[j] < rightArr[i]) {
                    rightArr[i] = rightArr[j] + 1;
                }
            }
        }

        int[] leftArr = new int[n];
        leftArr[0] = 0;
        for (int i = 1; i < n; i++) {
            leftArr[i] = leftArr[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] == arr[j] && leftArr[j] < leftArr[i]) {
                    leftArr[i] = leftArr[j] + 1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (arr[0] == arr[i]) {
                for (int j = 1; j < n - 1; j++) {
                    if (arr[n - 1] == arr[j]) {
                        min = Math.min(rightArr[i] + (Math.abs(i - j)) + leftArr[j], min);
                    }
                }
            }
        }

        return min;
    }

}
