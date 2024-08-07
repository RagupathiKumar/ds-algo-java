package gcl65.Session16;

public class LongestIncreasingSubsequenceApproach3 {

    public static void main(String[] args) {
        LongestIncreasingSubsequenceApproach3 app = new LongestIncreasingSubsequenceApproach3();
        System.out.println(app.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(app.lengthOfLIS(new int[]{9, 2, 4, 10, 1, 6, 7, 15, 3})); // 5
        System.out.println(app.lengthOfLIS(new int[]{2, 10, 3, 4, 7})); // 4
        System.out.println(app.lengthOfLIS(new int[]{8, 4, 6, 1, 9, 10, 2, 5, 7, 0})); // 4
        System.out.println(app.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})); // 1
        System.out.println(app.lengthOfLIS(new int[]{3, 1, 5, 2, 7})); // 3
        System.out.println(app.lengthOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12})); // 6
    }

    // Approach 3 : Using Binary Search
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int len = 0;
        int[] arr = new int[n];
        arr[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > arr[len]) {
                arr[++len] = nums[i];
            } else {
                int index = bs(arr, len, nums[i]);
                arr[index] = nums[i];
            }
        }

        return len + 1;
    }

    private int bs(int[] arr, int len, int num) {
        int s = 0, e = len;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (num < arr[m]) {
                e = m - 1;
            } else if (num > arr[m]) {
                s = m + 1;
            } else {
                return m;
            }
        }
        return s;
    }
}