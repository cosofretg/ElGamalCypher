package utils;

import java.util.ArrayList;
import java.util.List;

public class Factoring {

    /* util class for factorizing a number */

    public static List<Integer> factorize(int number) {
        List<Integer> primeFactors = new ArrayList<>();
        int factorNumber = 1;
        while(factorNumber <= number){
            if(number % factorNumber == 0){
                primeFactors.add(factorNumber);
            }
            factorNumber ++;
        }
        return primeFactors;
    }
}
