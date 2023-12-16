package gcl65.Session2;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] arr = {0, 2, 1, 3, 0, 1, 2, 1, 2, 1};

        getWaterSum(arr);
        getWaterSum2(arr);
    }

    // time - O(N), space - O(N)
    private static void getWaterSum2(int[] arr) {

        // time - O(N), space - O(N)
        int[] leftMaxArr = new int[arr.length];
        int leftMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            leftMax = Math.max(arr[i - 1], leftMax);
            leftMaxArr[i] = leftMax;
        }

        // time - O(N), space - O(N)
        int[] rightMaxArr = new int[arr.length];
        int rightMax = Integer.MIN_VALUE;
        for (int i = arr.length - 2; i > 0; i--) {
            rightMax = Math.max(arr[i + 1], rightMax);
            rightMaxArr[i] = rightMax;
        }

        // time - O(N)
        int waterSum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            waterSum += Math.max(Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i], 0);
        }

        System.out.println(waterSum);
    }

    // O(N square)
    private static void getWaterSum(int[] arr) {
        int waterSum = 0;

        for (int i = 1; i < arr.length - 1; i++) {

            int leftMax = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(arr[j], leftMax);
            }

            int rightMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                rightMax = Math.max(arr[j], rightMax);
            }

            waterSum += Math.max(Math.min(leftMax, rightMax) - arr[i], 0);
        }

        System.out.println(waterSum);
    }
}
