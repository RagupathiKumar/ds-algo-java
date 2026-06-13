package gcl65_2.Session3;

class LinearSearch{

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[] {3, 5, 1, 2, 7}, 2));
        System.out.println(linearSearch(new int[] {3, 5, 1, 2, 7}, 20));
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
}  