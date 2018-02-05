package utils;

import java.util.Random;

public class PrimeNumber {

    /* util class for handling prime numbers */

    private static final int min = 0;
    private static final int max = Integer.MAX_VALUE; // 2 ^ 31 - 1 = 2 147 483 647

    public static boolean isPrimeNumber(int number) {
        for(int i = 2; 2*i < number; i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public static int getRandomPrimeNumber() {
        Random rand = new Random();
        int outPrimeNumber;
        do {
            outPrimeNumber = rand.nextInt(max - min) + min;
        } while(!isPrimeNumber(outPrimeNumber));
        return outPrimeNumber;
    }
}
