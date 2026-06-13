package gcl65_2.Session1;

// https://leetcode.com/problems/excel-sheet-column-title/

public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(1)); // A
        System.out.println(convertToTitle(28)); // AB
        System.out.println(convertToTitle(701)); // ZY
        System.out.println(convertToTitle(52)); // AZ
    }

    static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber -= 1;
            sb.append((char) (65 + (columnNumber % 26)));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
