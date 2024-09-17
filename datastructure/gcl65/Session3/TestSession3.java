package gcl65.Session3;

public class TestSession3 {

    public static void main(String[] args) {

        int[] arr1 = {3, 5, 1, 2, 7}; // 3
        System.out.println(linearSearch(arr1, 2));

        int[] arr2 = {1, 3, 4, 6, 8, 9, 10}; // 4
        System.out.println(binarySearch(arr2, 8));

        int[] arr3 = {1, 3, 4, 4, 4, 4, 8, 9, 10}; // 2 5
        findFirstAndLastPos(arr3, 4);
        findFirstAndLastPos2(arr3, 4);
    }

    private static int linearSearch(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static void findFirstAndLastPos(int[] arr, int target) {
        int first = -1, last = -1;

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                first = mid;
                end = mid - 1;
            }
        }

        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                last = mid;
                start = mid + 1;
            }
        }

        System.out.println(first + " " + last);
    }

    private static void findFirstAndLastPos2(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int first = -1, last = -1;

        int index = binarySearch(arr, target, start, end);
        while (index != -1) {
            first = index;
            index = binarySearch(arr, target, start, first - 1);
        }

        index = binarySearch(arr, target, start, end);
        while (index != -1) {
            last = index;
            index = binarySearch(arr, target, last + 1, end);
        }

        System.out.println(first + " " + last);
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
