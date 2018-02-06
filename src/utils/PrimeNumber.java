package utils;

import java.util.Random;

public class PrimeNumber {

    /* util class for handling prime numbers */

    private int min = 0;
    private int max = Integer.MAX_VALUE; // 2 ^ 31 - 1 = 2 147 483 647

    public PrimeNumber() {}

    public boolean isPrime(long number){
        for(int i = 2 ; i <= (number / 2) ; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public SafePrimeNumber getSafeRandomPrimeNumber() {
        /* we want to generate a prime number in form p = 2 * q + 1 */
        long p;
        long q;
        q = (long) getRandomPrimeNumber();
        p = 2 * q + 1;
        return new SafePrimeNumber(p,q);
    }

    private int getRandomPrimeNumber() {
        Random rand = new Random();
        int outPrimeNumber;
        do {
            outPrimeNumber = rand.nextInt(max - min) + min;
        } while(!isPrime(outPrimeNumber));
        return outPrimeNumber;
    }
}
