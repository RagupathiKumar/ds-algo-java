package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/
public class SummaryRanges {

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[] { 0 }));
        System.out.println(summaryRanges(new int[] { 0,9 }));
        System.out.println(summaryRanges(new int[] { 0,1 }));
        System.out.println(summaryRanges(new int[] { 0,1,2,4,5,7 }));
        System.out.println(summaryRanges(new int[] { 0,2,3,4,6,8,9 }));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        int n = nums.length;
        int i = 0;
        while (i < n) {

            int j = i;
            while (j + 1 < n && nums[j] + 1 == nums[j + 1]) {
                j++;
            }

            ranges.add(nums[i] + (i == j ? "" : "->" + nums[j]));
            i = j + 1;
        }

        return ranges;
    }
}
