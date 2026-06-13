package gcl65.Session4;

public class ValidAnagram {

    public static void main(String[] args) {

        String s1 = "anagram";
        String s2 = "nagaram";

        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum += s1.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            sum -= s2.charAt(i);
        }

        System.out.println(sum == 0);

        System.out.println(isAnagram(s1, s2));
    }

    // Chaman's solution
    private static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }

        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
