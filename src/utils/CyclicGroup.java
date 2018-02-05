package utils;

import java.util.List;

public class CyclicGroup {

    /* utils class for handling the cyclic groups and for obatin the generator of a such group */

    public static int getCyclicGroupGenerator(int primeRandom) {
        List<Integer> primeFactors = Factoring.factorize(primeRandom - 1);
        for (int i = 0; i <= primeFactors.size(); i++) {
            
        }
        return 0;
    }

}
