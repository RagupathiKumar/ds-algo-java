package gcl65_2.Session3;

class FirstAndLastPos{

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 4, 4, 4, 5, 9, 10};
        int target =  4;

        int first = binarySearchFirstPosition(arr, target);
        int last = binarySearchLastPosition(arr, target);
        System.out.println(first + " " + last);
    }

    private static int binarySearchFirstPosition(int[] arr, int target) {
        int start = 0, end = arr.length - 1, pos = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                pos = mid;
                end = mid - 1;
            }
        }
        return pos;
    }

    private static int binarySearchLastPosition(int[] arr, int target) {
        int start = 0, end = arr.length - 1, pos = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                pos = mid;
                start = mid + 1;
            }
        }
        return pos;
    }

}  