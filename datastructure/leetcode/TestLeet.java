package leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class TestLeet {

    public int removeElement(int[] nums, int val) {
        int k = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }


    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > target) {
                continue;
            }
            int bal = (nums[i] < 0) ? nums[i] + target : target - nums[i];
            if (map.containsKey(bal)) {
                return new int[] {map.get(bal), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {-1, -1};
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length, k = 0;
        for (int i = 0; i < n; i++) {
            if ((i < n - 1 && nums[i] != nums[i + 1]) || i == n - 1) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length, plus = 1;
        for (int i = n - 1; i >= 0 && plus > 0; i--) {
            int num = digits[i] + 1;
            digits[i] = num % 10;
            plus = num / 10;
        }
        if (plus > 0) {
            digits = new int[n + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = Integer.MAX_VALUE, profit = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n, i = m - 1, j = n - 1;
        for (int index = len - 1; index >= 0; index--) {
            if (i >= 0 && j < 0) {
                nums1[index] = nums1[i];
                i--;
            } else if (j >= 0 && i < 0) {
                nums1[index] = nums2[j];
                j--;
            } else if (i >= 0 && nums2[j] >= nums1[i]) {
                nums1[index] = nums2[j];
                j--;
            } else if (j >= 0 && nums1[i] >= nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            }
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                break;
            }
        }
        return i >= j;
    }

    public boolean isHappy(int n) {
        Set<Integer> sums = new HashSet<>();
        while (n != 1) {
            if (sums.contains(n)) {
                return false;
            }
            sums.add(n);
            n = squareSum(n);
        }
        return true;
    }

    public boolean isHappyNg(int n) {
        int slow = n, fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int squareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem * rem;
            num /= 10;
        }
        return sum;
    }

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char t = s[i];
            s[i++] = s[j];
            s[j--] = t;
        }
    }

}
