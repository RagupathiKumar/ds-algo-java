package leetcode.practice3;

public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC")); // ABC
        System.out.println(gcdOfStrings("ABABAB", "ABAB")); // AB
        System.out.println(gcdOfStrings("ABABABAB", "ABAB")); // ABAB
        System.out.println(gcdOfStrings("LEET", "CODE")); // ""
        System.out.println(gcdOfStrings("AAAAAB", "AAA")); // ""
        System.out.println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX")); // "TAUXX"
    }

    static String gcdOfStrings(String str1, String str2) {
        String div = "";
        int len1 = str1.length(), len2 = str2.length();

        for (int i = 0; i < len2; i++) {
            String s = str2.substring(0, i + 1);
            int len = s.length();
            boolean dividable = true;

            for (int j = 0; j < Math.max(len1, len2); j+=len) {
                if (j < len1) {
                    if (!str1.substring(j, Math.min(j+len, len1)).equals(s)) {
                        dividable = false;
                        break;
                    }
                }
                if (j < len2) {
                    if (!str2.substring(j, Math.min(j+len, len2)).equals(s)) {
                        dividable = false;
                        break;
                    }
                }
            }

            if (dividable) {
                div = s;
            }
        }
        return div;
    }


}
