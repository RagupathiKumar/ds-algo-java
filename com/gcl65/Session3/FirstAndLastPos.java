package gcl65.Session3;

public class FirstAndLastPos {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 4, 4, 4, 8, 9, 10};
        int target = 4;

        int first = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                first = mid;
                end = mid - 1;
            }
        }

        int last = -1;
        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                last = mid;
                start = mid + 1;
            }
        }

        System.out.println(first + " " + last);
    }

}
