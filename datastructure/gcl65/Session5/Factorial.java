package gcl65.Session5;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    private static int fact(int num) {
        // base case
        if (num == 1) {
            return 1;
        }
        // recursive case
        return num * fact(num - 1);
    }

}
