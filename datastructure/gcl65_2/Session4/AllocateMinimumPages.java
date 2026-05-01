package gcl65_2.Session4;
// https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
public class AllocateMinimumPages {

    public static void main(String[] args) {
        AllocateMinimumPages thisObj = new AllocateMinimumPages();

        System.out.println(thisObj.findPages(new int[] {12, 34, 67, 90}, 2));
        System.out.println(thisObj.findPages(new int[] {15, 17, 20}, 5));
        System.out.println(thisObj.findPages(new int[] {15, 10, 19, 10, 5, 18, 7}, 5));
        System.out.println(thisObj.findPages(new int[] {13, 31, 37, 45, 46, 54, 55, 63, 73, 84, 85}, 9));

    }

    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            return -1;
        }

        int minPages = Integer.MIN_VALUE, maxPages = 0;
        for (int i = 0; i < n; i++) {
            minPages = Math.max(arr[i], minPages);
            maxPages += arr[i];
        }

        int allocatedMinPages = -1;
        while (minPages <= maxPages) {
            int midPages = minPages + (maxPages - minPages) / 2;
            int studs = calculateStudents(arr, midPages, k);
            if (studs <= k) {
                allocatedMinPages = midPages;
                maxPages = midPages - 1;
            } else {
                minPages = midPages + 1;
            }
        }
        return allocatedMinPages;
    }

    private int calculateStudents(int[] arr, int minPages, int k) {
        int n = arr.length;
        int sumPages = 0, studs = 0;
        for (int i = 0; i < n; i++) {
            sumPages += arr[i];
            if (sumPages > minPages) {
                studs++;
                sumPages = arr[i];
            }
        }
        if (sumPages > 0) {
            studs++;
        }
        return studs;
    }

}
