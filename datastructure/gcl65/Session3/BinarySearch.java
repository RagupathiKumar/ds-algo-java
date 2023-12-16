package gcl65.Session3;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 6, 8, 9, 10};
        int target = 8;

        int start = 0;
        int end = arr.length - 1;
        int index = -1;
        while (start <= end) {

            int mid = (start + end) / 2;
            // int mid = start + ((end - start) / 2); -- to overcome integer overflow

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                index = mid;
                break;
            }
        }

        System.out.println(index);

    }
}
