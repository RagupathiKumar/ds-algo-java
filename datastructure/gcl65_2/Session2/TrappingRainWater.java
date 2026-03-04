package gcl65_2.Session2;

class TrappingRainWater{

    public static void main(String[] args) {
        System.out.println(water(new int[] {0, 2, 1, 3, 0, 1, 2, 1, 2, 1}));
    }

    private static int water(int[] arr) {
        int n = arr.length;

        int[] leftMaxHeight = new int[n];
        leftMaxHeight[0] = 0;
        for (int i = 1; i < n; i++) {
            leftMaxHeight[i] = Math.max(arr[i - 1], leftMaxHeight[i - 1]);
        }

        int[] rightMaxHeight = new int[n];
        rightMaxHeight[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(arr[i + 1], rightMaxHeight[i + 1]);
        }

        int waterUnits = 0;
        for (int i = 0; i < n; i++) {
            waterUnits += Math.max(Math.min(leftMaxHeight[i], rightMaxHeight[i]) - arr[i], 0);
        }
        return waterUnits;
    }
}  