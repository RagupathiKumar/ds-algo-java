package gcl65.Session15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public static void main(String[] args) {

        int[] start = {1, 1, 3, 6, 9, 10};
        int[] end = {4, 7, 5, 8, 11, 12};

        System.out.println(activitySelection2(start, end, start.length));
    }

    // BRUTE FORCE approach -- Time - O(N square), Space - O(1)
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


    // Time - O(NlogN), Space - O(N)
    public static class Activity {
        int start;
        int end;
        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int activitySelection2(int[] start, int[] end, int n) {
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], end[i]));
        }
        activities.sort(Comparator.comparingInt(a -> a.end));

        int max = 1;
        int currEnd = activities.get(0).end;
        for (int i = 1; i < n; i++) {
            if (currEnd < activities.get(i).start) {
                max++;
                currEnd = activities.get(i).end;
            }
        }
        return max;
    }

}