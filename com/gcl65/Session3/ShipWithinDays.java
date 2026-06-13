package gcl65.Session3;

import java.util.Arrays;

public class ShipWithinDays {

    public static void main(String[] args) {

        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        // findCapacity(weights, days);


        int startCapacity = Integer.MIN_VALUE, endCapacity = 0;
        for (int weight : weights) {
            startCapacity = Math.max(startCapacity, weight);
            endCapacity += weight;
        }

        while (startCapacity <= endCapacity) {

            int midCapacity = (startCapacity + endCapacity) / 2;

            int currentCapacity = 0;
            int noOfDays = 0;
            for (int i = 0; i < weights.length; i++) {

                currentCapacity += weights[i];

                if (currentCapacity == midCapacity) {
                    noOfDays += 1;
                    currentCapacity = 0;
                } else if (currentCapacity > midCapacity){
                    i -= 1;
                    noOfDays += 1;
                    currentCapacity = 0;
                }
            }

            if (currentCapacity > 0) {
                noOfDays += 1;
            }

            if (noOfDays < days) {
                endCapacity = midCapacity - 1;
            } else if (noOfDays > days) {
                startCapacity = midCapacity + 1;
            } else {
                System.out.println(midCapacity);
                break;
            }

        }


    }

    private static void findCapacity(int[] weights, int days) {
        int capacity = Integer.MIN_VALUE;
        for (int weight : weights) {
            capacity = Math.max(capacity, weight);
        }

        int noOfDays;
        int currentCapacity;

        while (true) {

            currentCapacity = 0;
            noOfDays = 1;

            for (int i = 0; i < weights.length; i++) {
                currentCapacity += weights[i];
                if (currentCapacity > capacity){
                    noOfDays += 1;
                    currentCapacity = weights[i];
                }
            }

            if (noOfDays == days) {
                break;
            } else {
                capacity += 1;
            }
        }

        System.out.println(capacity);
    }
}
