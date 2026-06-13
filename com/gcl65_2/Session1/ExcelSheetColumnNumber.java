package gcl65_2.Session1;

// https://leetcode.com/problems/excel-sheet-column-number/

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("A")); // A 1
        System.out.println(titleToNumber("AB")); // AB 28
        System.out.println(titleToNumber("ZY")); // ZY 701
        System.out.println(titleToNumber("AZ")); // AZ 52
    }

    static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int n = chars.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (chars[i] - 65 + 1) * Math.pow(26, n - 1 - i);
        }
        return sum;
    }

}
