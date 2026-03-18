package gcl65_2.Session3;

class SearchInRotatedSorted{

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {4, 5, 7, 9, 1, 2, 3}, 7));
        System.out.println(binarySearch(new int[] {4, 5, 7, 9, 1, 2, 3}, 1));
        System.out.println(binarySearch(new int[] {4, 5, 7, 9, 1, 2, 3}, 4));
        System.out.println(binarySearch(new int[] {4, 5, 7, 9, 1, 2, 3}, 3));
        System.out.println(binarySearch(new int[] {4, 5, 7, 9, 1, 2, 3}, 6));
        System.out.println(binarySearch(new int[] {4, 5, 7, 9, 1, 2, 3}, 0));
    }

    private static int binarySearch(int[] arr, int target) {
        int n = arr.length;
        int s = 0, e = n - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (target < arr[mid]) {
                if (arr[s] <= target && target <= arr[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (target > arr[mid]) {
                if (arr[mid] <= target && target <= arr[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}  