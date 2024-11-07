public class TestCiti {

    public static void main(String[] args) {

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        System.out.println(getIndex(arr, 3));

    }

    private static int getIndex(int[] arr, int num) {
        int n = arr.length;
        if (n == 0) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

}
