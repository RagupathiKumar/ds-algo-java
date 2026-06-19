package leetcode.practice3;

public class AngleBetweenHandsOfAClock {

    public static void main(String[] args) {
                System.out.println(angleClock(12, 30)); // 165.0
        System.out.println(angleClock(3, 30)); // 75.0
        System.out.println(angleClock(3, 15)); // 7.5
        System.out.println(angleClock(1, 57)); // 76.50000
    }

    static double angleClock(int hour, int minutes) {
        double angle = Math.abs((((hour % 12) * 5) + ((double) minutes / 12)) - minutes) * 6;
        return angle < 180 ? angle : 360 - angle;
    }

}