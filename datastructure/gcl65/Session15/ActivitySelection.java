package gcl65.Session15;

public class ActivitySelection {

    public static void main(String[] args) {

        int[] start = {1, 1, 3, 6, 9, 10};
        int[] end = {4, 7, 5, 8, 11, 12};

        System.out.println(activitySelection(start, end, start.length));
    }

    // BRUTE FORCE approach
    public static int activitySelection(int[] start, int[] end, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int currEnd = end[i];
            for (int j = i + 1; j < n; j++) {
                if (start[j] > currEnd) {
                    cnt++;
                    currEnd = end[j];
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

}