package gcl65.Session3;

public class LinearSearch {

    public static void main(String[] args) {

        int[] arr = {3, 5, 1, 2, 7};
        int target = 2;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;
            }
        }

        System.out.println(index);
    }
}
