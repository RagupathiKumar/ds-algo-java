package gcl65_2.Session1;

public class CountPairsWithGivenSum {

    public static void main(String[] args) {
        int count = countPairsWithGivenSum(new int[]{1, 3, 4, 8, 9, 11, 12, 15}, 12);
        System.out.println(count);

        count = countPairsWithGivenSum(new int[] {1, 3, 4, 8, 9, 11, 12, 15}, 13);
        System.out.println(count);
    }

    private static int countPairsWithGivenSum(int[] arr, int sum) {
        int count = 0;

        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] > sum) {
                j--;
            } else if (arr[i] + arr[j] < sum) {
                i++;
            } else {
                count++;
                i++;
                j--;
            }
        }

        return count == 0 ? -1 : count;
    }

}
