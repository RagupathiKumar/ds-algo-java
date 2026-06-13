package gcl65.Session3;

public class SearchInRotatedSorted {

    public static void main(String[] args) {

        int[] arr = {6, 7, 1, 2, 3, 4, 5};
        int target = 7;

        int start = 0, end = arr.length - 1, mid = -1;
        boolean found = false;

        while (start <= end) {

            mid = (start + end) / 2;

            if (target == arr[mid]) {
                System.out.println(mid);
                found = true;
                break;
            } else if (arr[mid] <= arr[end]) {
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }


        System.out.println(found);
    }
}
