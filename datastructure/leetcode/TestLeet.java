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

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (vowels.indexOf(chars[i]) != -1) {
                i++;
            } else if (vowels.indexOf(chars[j]) != -1) {
                j--;
            } else {
                char t = chars[i];
                chars[i++] = chars[j];
                chars[j--] = t;
            }
        }
        return new String(chars);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            map.put(nums1[i], 1);
        }

        int m = nums2.length;
        for (int i = 0; i < m; i++) {
            map.computeIfPresent(nums2[i], (k, v) -> 2);
        }

         return map.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .mapToInt(e -> e.getKey())
                .toArray();
    }

    public int[] intersectionNg(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;

        Set<Integer> set = new HashSet<>();
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }

        return set.stream().mapToInt(v -> v).toArray();
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];

        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            arr[nums1[i]] = 1;
        }

        int m = nums2.length;
        int size = 0;
        for (int i = 0; i < m; i++) {
            if (arr[nums2[i]] == 1) {
                arr[nums2[i]] = 2;
                size++;
            }
        }

        int[] result = new int[size];
        for (int i = 0, j = 0; i < 1001; i++) {
            if (arr[i] > 1) {
                result[j] = i;
                j++;
            }
        }

        return result;
    }

    public int[] intersectProblem2(int[] nums1, int[] nums2) {
        int[] freq1 = new int[1001];
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            freq1[nums1[i]] += 1;
        }

        int[] freq2 = new int[1001];
        int m = nums2.length;
        for (int i = 0; i < m; i++) {
            freq2[nums2[i]] += 1;
        }

        int size = 0;
        for (int i = 0; i < 1001; i++) {
            size += Math.min(freq1[i], freq2[i]);
        }

        int[] result = new int[size];
        int index = 0;
        for (int i = 0; i < 1001; i++) {
            int freq = Math.min(freq1[i], freq2[i]);
            for (int j = 0; j < freq; j++) {
                result[index] = i;
                index++;
            }
        }

        return result;
    }

    public int[] intersectProblem2Solution2(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            freq[nums1[i]] += 1;
        }

        List<Integer> result = new ArrayList<>();
        int m = nums2.length;
        for (int i = 0; i < m; i++) {
            if (freq[nums2[i]] > 0) {
                result.add(nums2[i]);
                freq[nums2[i]] -= 1;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
