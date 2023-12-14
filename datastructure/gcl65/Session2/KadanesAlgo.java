package gcl65.Session2;

// find the max value of a sub array
public class KadanesAlgo {

    public static void main(String[] args) {

        int[] arr = {2, -5, 7, -6, 5, 4, -10};
//        int[] arr = {-4, -2, -6, -1};

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : arr) {
            currSum += num;

            maxSum = Math.max(maxSum, currSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }

        System.out.println(maxSum);
    }

}
