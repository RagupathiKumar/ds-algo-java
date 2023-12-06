package gcl65.Session1;

public class CountPairs {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 8, 9, 11, 12, 15};
        System.out.println("Pairs count = " + countPairs(arr, 13));
        System.out.println("Pairs count = " + countPairs(arr, 12));
    }

    private static int countPairs(int[] arr, int sum) {

        int cnt = 0;
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int total = arr[i] + arr[j];
            if (total > sum) {
                j--;
            } else if (total < sum) {
                i++;
            } else {
                cnt += 1;
                i++;
                j--;
            }
        }

        return cnt > 0 ? cnt : -1;
    }

}
