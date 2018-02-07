package utils;

import java.util.Random;

public class PrimeNumber {

    /* util class for handling prime numbers */

    private int min = 2;
    private int max = 10;

    public PrimeNumber() { }

    public boolean isPrime(int number){
        for(int i = 2 ; i <= (number / 2) ; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public SafePrimeNumber getSafeRandomPrimeNumber() {
        int pNumber = getRandomPrimeNumber(), p, q;
        p = pNumber;
        q = p / 2;
        return new SafePrimeNumber(p,q);
    }

    public int getRandomPrimeNumber() {
        Random rand = new Random();
        int outPrimeNumberQ;
        int outPrimeNumberP;
        do {
            outPrimeNumberQ = rand.nextInt(max - min) + min;
            outPrimeNumberP = (2 * outPrimeNumberQ) + 1;
        } while(!( isPrime(outPrimeNumberP) && isPrime(outPrimeNumberQ) ));
        return outPrimeNumberP;
    }
}
