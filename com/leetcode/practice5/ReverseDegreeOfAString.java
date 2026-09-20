package leetcode.practice5;

public class ReverseDegreeOfAString {

    public static void main(String[] args) {
        System.out.println(reverseDegree("abc")); // 148
        System.out.println(reverseDegree("zaza")); // 160
    }

    static int reverseDegree(String s) {
        int n = s.length(), degree = 0;
        for (int i = 0; i < n; i++) {
            degree += (123 - s.charAt(i)) * (i + 1);
        }
        return degree;
    }

}
