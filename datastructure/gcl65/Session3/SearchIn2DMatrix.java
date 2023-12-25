package gcl65.Session3;

public class SearchIn2DMatrix {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int target = 3;

        search(arr, target);
        searchByChaman(arr, target);
    }

    private static void searchByChaman(int[][] arr, int target) {

    }

    // Space -- O(1), Time -- O(logN + logM)
    // BS to find right row and BS to find right column
    private static void search(int[][] arr, int target) {
        int startRow = 0, endRow = arr.length - 1;
        int startCol = 0, endCol = arr[0].length - 1;
        boolean found = false;

        while (startRow <= endRow) {
            int midRow = (startRow + endRow) / 2;

            if (target >= arr[midRow][startCol] && target <= arr[midRow][endCol]) {

                while (startCol <= endCol) {

                    int midCol = (startCol + endCol) / 2;
                    if (target < arr[midRow][midCol]) {
                        endCol = midCol - 1;
                    } else if (target > arr[midRow][midCol]) {
                        startCol = midCol + 1;
                    } else {
                        System.out.println(midRow + " x " + midCol);
                        found = true;
                        break;
                    }
                }

                break;
            } else if (target < arr[midRow][startCol]) {
                endRow = midRow - 1;
            } else if (target > arr[midRow][startCol]) {
                startRow = midRow + 1;
            }
        }

        System.out.println(found);
    }

}
