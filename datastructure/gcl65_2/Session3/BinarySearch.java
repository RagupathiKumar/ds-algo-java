package gcl65_2.Session3;

class BinarySearch{

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {1,2, 3, 4, 7, 9, 10, 11}, 7));
        System.out.println(binarySearch(new int[] {1,2, 3, 4, 7, 9, 10, 11}, 1));
        System.out.println(binarySearch(new int[] {1,2, 3, 4, 7, 9, 10, 11}, 11));
        System.out.println(binarySearch(new int[] {1,2, 3, 4, 7, 9, 10, 11}, 0));
        System.out.println(binarySearch(new int[] {1,2, 3, 4, 7, 9, 10, 11}, 12));
        System.out.println(binarySearch(new int[] {1,2, 3, 4, 7, 9, 10, 11}, 5));
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}  