package gcl65.Session3;

public class TestSession3_BS {

    public static void main(String[] args) {

        int[] arr1 = {3, 5, 1, 2, 7}; // 3
        System.out.println(linearSearch(arr1, 2));

        int[] arr2 = {1, 3, 4, 6, 8, 9, 10}; // 4
        System.out.println(binarySearch(arr2, 8));

        int[] arr3 = {1, 3, 4, 4, 4, 4, 8, 9, 10}; // 2 5
        findFirstAndLastPos(arr3, 4);
        findFirstAndLastPos2(arr3, 4);

        // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
        System.out.println(shipWithinDays(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)); // 15
        System.out.println(shipWithinDays(new int[] {3,2,2,4,1,4}, 3)); // 6
        System.out.println(shipWithinDays(new int[] {1,2,3,1,1}, 4)); // 3

        int[] arr5 = {6, 7, 1, 2, 3, 4, 5};
        int target = 7;
        System.out.println(searchInRotatedArray(arr5, target));

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(searchIn2DArray(arr, 3));
        System.out.println(searchIn2DArray(arr, 17));
    }

    private static boolean searchIn2DArray(int[][] arr, int target) {
        int rows = arr.length, cols = arr[0].length;
        int start = 0, end = rows * cols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / rows, col = mid % cols;

            if (arr[row][col] < target) {
                start = mid + 1;
            } else if (arr[row][col] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static int searchInRotatedArray(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[start] <= arr[mid]) { // left arr is sorted
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // right array is sorted
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int minRequiredCapc = 0, maxRequiredCapc = 0;
        for (int weight : weights) {
            minRequiredCapc = Math.max(minRequiredCapc, weight);
            maxRequiredCapc += weight;
        }

        while (minRequiredCapc <= maxRequiredCapc) {
            int midCapc = (minRequiredCapc + maxRequiredCapc) / 2;
            int calcDays = getDays(weights, midCapc);
            if (calcDays <= days) {
                maxRequiredCapc = midCapc - 1;
            } else {
                minRequiredCapc = midCapc + 1;
            }
        }

        return minRequiredCapc;
    }

    public static int getDays(int[] weights, int capacity) {
        int days = 1;
        int currCapc = 0;
        for (int weight : weights) {
            currCapc += weight;
            if (currCapc > capacity) {
                days += 1;
                currCapc = weight;
            }
        }
        return days;
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
