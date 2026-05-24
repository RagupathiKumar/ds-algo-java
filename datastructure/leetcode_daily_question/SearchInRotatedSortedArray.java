package leetcode_daily_question;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[] {7,0,1,2,4,5,6}, 0));
        System.out.println(search(new int[] {0,1,2,4,5,6,7}, 0));
        System.out.println(search(new int[] {0,1,2,4,5,6,7}, 9));
        System.out.println(search(new int[] {1}, 2));
    }

    static int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[s] <= nums[mid]) {
                if (nums[s] <= target && target <= nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (nums[mid] <= nums[e]) {
                if (nums[mid] <= target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }

}
