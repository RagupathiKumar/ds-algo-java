package gcl65_2.Session4;

// https://leetcode.com/problems/reverse-words-in-a-string-iii/

class ReverseWordsInString {

    public static void main(String[] args) {
        String s = new ReverseWordsInString().reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] == ' ') {
                reverseWords(arr, i, j - 1);
                i = j + 1;
            }
        }
        reverseWords(arr, i, n - 1);

        return String.valueOf(arr);
    }

    private void reverseWords(char[] arr, int i, int j) {
        while (i < j) {
            char t = arr[i];
            arr[i++] = arr[j];
            arr[j--] = t;
        }
    }

}